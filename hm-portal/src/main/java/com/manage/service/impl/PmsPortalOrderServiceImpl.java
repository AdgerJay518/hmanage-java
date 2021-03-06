package com.manage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.manage.common.api.CommonPage;
import com.manage.common.service.RedisService;
import com.manage.dao.PortalOrderDao;
import com.manage.dao.PortalOrderItemDao;
import com.manage.domin.PmsOrderDetail;
import com.manage.dto.OrderParam;
import com.manage.dto.manageParam;
import com.manage.mapper.PmsOrderItemMapper;
import com.manage.mapper.PmsOrderMapper;
import com.manage.model.*;
import com.manage.service.PlanItemService;
import com.manage.service.PmsPortalOrderService;
import com.manage.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jonyon on 2021/10/9.
 */
@Service
public class PmsPortalOrderServiceImpl implements PmsPortalOrderService {
    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private PmsOrderMapper orderMapper;

    @Autowired
    private PmsOrderItemMapper orderItemMapper;

    @Autowired
    private PlanItemService planItemService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private PortalOrderDao orderDao;

    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Autowired
    private PortalOrderItemDao orderItemDao;

    @Override
    public CommonPage<PmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize) {
        if(status==-1){
            status = null;
        }
        UmsMember member = memberService.getCurrentMember();
        PageHelper.startPage(pageNum,pageSize);
        PmsOrder pmsOrder = new PmsOrder();
        pmsOrder.setMemberId(member.getId());
        if (status!=null){
            pmsOrder.setStatus(status);
        }
        List<PmsOrder> orderList = orderMapper.selectByPmsOrder(pmsOrder);
        CommonPage<PmsOrder> orderPage = CommonPage.restPage(orderList);
        //??????????????????
        CommonPage<PmsOrderDetail> resultPage = new CommonPage<>();
        resultPage.setPageNum(orderPage.getPageNum());
        resultPage.setPageSize(orderPage.getPageSize());
        resultPage.setTotal(orderPage.getTotal());
        resultPage.setTotalPage(orderPage.getTotalPage());
        if(CollUtil.isEmpty(orderList)){
            return resultPage;
        }
        //??????????????????
        List<Long> orderIds = orderMapper.getOrderId(pmsOrder);
        PmsOrderItemExample pmsOrderItemExample = new PmsOrderItemExample();
        pmsOrderItemExample.setOrderIds(orderIds);
        List<PmsOrderItem> orderItemList = orderItemMapper.selectByPmsOrderItem(pmsOrderItemExample);
        List<PmsOrderDetail> orderDetailList = new ArrayList<>();
        for (PmsOrder omsOrder : orderList) {
            PmsOrderDetail orderDetail = new PmsOrderDetail();
            BeanUtil.copyProperties(omsOrder,orderDetail);
            List<PmsOrderItem> relatedItemList = orderItemList.stream().filter(item -> item.getOrderId().equals(orderDetail.getId())).collect(Collectors.toList());
            orderDetail.setOrderItemList(relatedItemList);
            orderDetailList.add(orderDetail);
        }
        resultPage.setList(orderDetailList);
        return resultPage;
    }

    @Override
    public Map<String, Object> generateOrder(OrderParam orderParam) {
        List<PmsOrderItem> orderItemList = new ArrayList<>();
        UmsMember currentMember = memberService.getCurrentMember();
        List<PlanItem> planItemList=planItemService.getItemList(currentMember.getId(),orderParam.getPlanIds());
        for (PlanItem p:planItemList){
            PmsOrderItem pmsOrderItem = new PmsOrderItem();
            pmsOrderItem.setSfPic(p.getSfPic());
            pmsOrderItem.setSfId(p.getSfId());
            pmsOrderItem.setSfSn(p.getSfSn());
            pmsOrderItem.setSfName(p.getSfName());
            pmsOrderItem.setSfCalorie(p.getCalorie());
            pmsOrderItem.setSfQuantity(p.getQuantity());
            pmsOrderItem.setSfCategoryId(p.getSfCategoryId());
            orderItemList.add(pmsOrderItem);
        }
        PmsOrder order = new PmsOrder();
        order.setMemberId(currentMember.getId());
        order.setCreateTime(new Date());
        order.setStartTime(new Date());
        order.setConfirmTime(new Date());
        order.setMemberUsername(currentMember.getUsername());
        order.setSourceType(1);
        order.setTotalCalorie(orderParam.getTotalCalorie());
        order.setTotalTime(orderParam.getTotalTime());
        order.setStatus(0);
        order.setConfirmStatus(0);
        order.setDeleteStatus(0);
        order.setAutoConfirmDay(1);
        order.setPlanSn(generateOrderSn(order));
        orderMapper.insert(order);

        for (PmsOrderItem item:orderItemList){
            item.setOrderId(order.getId());
            item.setOrderSn(order.getPlanSn());
        }
        orderItemDao.insertList(orderItemList);
        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItemList", orderItemList);
        return result;
    }

    @Override
    public List<PlanItem> test(OrderParam orderParam) {
        UmsMember currentMember = memberService.getCurrentMember();

        return planItemService.getItemList(currentMember.getId(),orderParam.getPlanIds());
    }

    @Override
    public List<manageParam> selectCalorieByDate(String date) {
        String startTime=date+" "+"00:00:00";
        String endTime=date+" "+"24:59:59";
        List<manageParam> calorie = orderDao.getCalorie(startTime,endTime);
        List<manageParam> calorieFood = orderDao.getCalorieFood(startTime,endTime);
        int calorieSize = calorie.size();
        int calorieFoodSize = calorieFood.size();
        if (calorieSize>calorieFoodSize){
            calorie.addAll(calorieFood);
            return calorie;
        }
        if (calorieSize<calorieFoodSize){
            calorieFood.addAll(calorie);
            return calorieFood;
        }

        calorie.addAll(calorieFood);
        return calorie;
    }


    /**
     * ??????18???????????????:8?????????+2???????????????+6???????????????id
     */
    private String generateOrderSn(PmsOrder order) {
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
