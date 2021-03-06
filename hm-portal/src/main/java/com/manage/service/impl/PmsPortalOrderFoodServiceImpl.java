package com.manage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.manage.common.api.CommonPage;
import com.manage.common.service.RedisService;
import com.manage.dao.PortalOrderFoodItemDao;
import com.manage.domin.PmsOrderFoodDetail;
import com.manage.dto.OrderFoodParam;
import com.manage.mapper.PmsOrderFoodItemMapper;
import com.manage.mapper.PmsOrderFoodMapper;
import com.manage.model.*;
import com.manage.service.PlanItemFoodService;
import com.manage.service.PmsPortalOrderFoodService;
import com.manage.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PmsPortalOrderFoodServiceImpl implements PmsPortalOrderFoodService {
    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private PmsOrderFoodMapper pmsOrderFoodMapper;

    @Autowired
    private PmsOrderFoodItemMapper pmsOrderFoodItemMapper;

    @Autowired
    private PlanItemFoodService planItemFoodService;

    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Autowired
    private RedisService redisService;

    @Autowired
    private PortalOrderFoodItemDao orderFoodItemDao;

    @Override
    public Map<String, Object> generateOrder(OrderFoodParam orderFoodParam) {
        List<PmsOrderFoodItem> orderItemList = new ArrayList<>();
        UmsMember currentMember = memberService.getCurrentMember();
        List<PlanItemFood> itemFoodList = planItemFoodService.getItemFoodList(currentMember.getId(),orderFoodParam.getPlanIds());
        for (PlanItemFood p:itemFoodList){
            PmsOrderFoodItem pmsOrderFoodItem = new PmsOrderFoodItem();
            pmsOrderFoodItem.setFoodPic(p.getFoodPic());
            pmsOrderFoodItem.setFoodId(p.getFoodId());
            pmsOrderFoodItem.setFoodSn(p.getFoodSn());
            pmsOrderFoodItem.setFoodName(p.getFoodName());
            pmsOrderFoodItem.setFoodCalorie(p.getCalorie());
            pmsOrderFoodItem.setFoodQuantity(p.getQuantity());
            pmsOrderFoodItem.setFoodCategoryId(p.getFoodCategoryId());
            orderItemList.add(pmsOrderFoodItem);
        }

        PmsOrderFood pmsOrderFood = new PmsOrderFood();
        pmsOrderFood.setMemberId(currentMember.getId());
        pmsOrderFood.setCreateTime(new Date());
        pmsOrderFood.setStartTime(new Date());
        pmsOrderFood.setConfirmTime(new Date());
        pmsOrderFood.setMemberUsername(currentMember.getUsername());
        pmsOrderFood.setSourceType(1);
        pmsOrderFood.setIngestionCalorie(orderFoodParam.getIngestionCalorie());
        pmsOrderFood.setTotalK(orderFoodParam.getTotalK());
        pmsOrderFood.setStatus(0);
        pmsOrderFood.setConfirmStatus(0);
        pmsOrderFood.setDeleteStatus(0);
        pmsOrderFood.setAutoConfirmDay(1);
        pmsOrderFood.setPlanSn(generateOrderSn(pmsOrderFood));
        pmsOrderFoodMapper.insert(pmsOrderFood);
        for (PmsOrderFoodItem item:orderItemList){
            item.setOrderId(pmsOrderFood.getId());
            item.setOrderSn(pmsOrderFood.getPlanSn());
        }
        orderFoodItemDao.insertList(orderItemList);
        Map<String, Object> result = new HashMap<>();
        result.put("orderFood", pmsOrderFood);
        result.put("orderFoodItemList", orderItemList);
        return result;
    }

    @Override
    public CommonPage<PmsOrderFoodDetail> list(Integer status, Integer pageNum, Integer pageSize) {
        if(status==-1){
            status = null;
        }
        UmsMember member = memberService.getCurrentMember();
        PageHelper.startPage(pageNum,pageSize);
        PmsOrderFood pmsOrderFood = new PmsOrderFood();
        pmsOrderFood.setMemberId(member.getId());
        if (status!=null){
            pmsOrderFood.setStatus(status);
        }
        List<PmsOrderFood> orderList = pmsOrderFoodMapper.selectByPmsOrder(pmsOrderFood);
        CommonPage<PmsOrderFood> orderPage = CommonPage.restPage(orderList);

        CommonPage<PmsOrderFoodDetail> resultPage = new CommonPage<>();
        resultPage.setPageNum(orderPage.getPageNum());
        resultPage.setPageSize(orderPage.getPageSize());
        resultPage.setTotal(orderPage.getTotal());
        resultPage.setTotalPage(orderPage.getTotalPage());
        if(CollUtil.isEmpty(orderList)){
            return resultPage;
        }


        List<Long> orderIds = pmsOrderFoodMapper.getOrderId(pmsOrderFood);
        PmsOrderItemExample pmsOrderItemExample = new PmsOrderItemExample();
        pmsOrderItemExample.setOrderIds(orderIds);
        List<PmsOrderFoodItem> orderItemList = pmsOrderFoodItemMapper.selectByPmsOrderItem(pmsOrderItemExample);
        List<PmsOrderFoodDetail> orderDetailList = new ArrayList<>();
        for (PmsOrderFood omsOrder : orderList) {
            PmsOrderFoodDetail orderDetail = new PmsOrderFoodDetail();
            BeanUtil.copyProperties(omsOrder,orderDetail);
            List<PmsOrderFoodItem> relatedItemList = orderItemList.stream().filter(item -> item.getOrderId().equals(orderDetail.getId())).collect(Collectors.toList());
            orderDetail.setOrderFoodItemList(relatedItemList);
            orderDetailList.add(orderDetail);
        }
        resultPage.setList(orderDetailList);
        return resultPage;
    }

    private String generateOrderSn(PmsOrderFood order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_DATABASE+":"+ REDIS_KEY_ORDER_ID + date;
        Long increment = redisService.incr(key, 1);
        sb.append(date);
        sb.append(String.format("%02d", order.getSourceType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }
}
