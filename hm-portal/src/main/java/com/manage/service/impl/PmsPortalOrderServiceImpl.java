package com.manage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.manage.common.api.CommonPage;
import com.manage.common.service.RedisService;
import com.manage.dao.PortalOrderItemDao;
import com.manage.domin.PlanItemList;
import com.manage.domin.PmsOrderDetail;
import com.manage.dto.OrderParam;
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
        //设置分页信息
        CommonPage<PmsOrderDetail> resultPage = new CommonPage<>();
        resultPage.setPageNum(orderPage.getPageNum());
        resultPage.setPageSize(orderPage.getPageSize());
        resultPage.setTotal(orderPage.getTotal());
        resultPage.setTotalPage(orderPage.getTotalPage());
        if(CollUtil.isEmpty(orderList)){
            return resultPage;
        }
        //设置数据信息
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


    /**
     * 生成18位订单编号:8位日期+2位平台号码+6位以上自增id
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
