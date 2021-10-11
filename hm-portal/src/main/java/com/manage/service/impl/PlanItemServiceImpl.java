package com.manage.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.manage.domin.PlanItemList;
import com.manage.mapper.PlanItemMapper;
import com.manage.mapper.PmsOrderItemMapper;
import com.manage.model.PlanItem;
import com.manage.model.UmsMember;
import com.manage.service.PlanItemService;
import com.manage.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jonyon on 2021/10/7.
 */
@Service
public class PlanItemServiceImpl implements PlanItemService {

    @Autowired
    private PlanItemMapper planItemMapper;
    @Autowired
    private UmsMemberService memberService;


    @Override
    public int add(PlanItem planItem) {
        int count;
        UmsMember currentMember =memberService.getCurrentMember();
        planItem.setMemberId(currentMember.getId());
        planItem.setMemberNickname(currentMember.getNickname());
        planItem.setDeleteStatus(0);
        PlanItem existPlanItem = getPlanItem(planItem);
        if (existPlanItem==null){
            planItem.setCreateDate(new Date());
            count=planItemMapper.insert(planItem);
        }
        else{
            planItem.setModifyDate(new Date());
            existPlanItem.setQuantity(existPlanItem.getQuantity()+planItem.getQuantity());
            count = planItemMapper.updateByPrimaryKey(existPlanItem);
        }
        return count;
    }

    @Override
    public List<PlanItem> list(Long id) {
        PlanItem planItem = new PlanItem();
        planItem.setMemberId(id);
        return planItemMapper.selectByPlan(planItem);
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
        PlanItem planItem = new PlanItem();
        planItem.setQuantity(quantity);
        planItem.setId(id);
        planItem.setMemberId(memberId);
        return planItemMapper.updateBySfAndMemberId(planItem);
    }

    @Override
    public int delete(Long memberId, Long id) {
        PlanItem planItem = new PlanItem();
        planItem.setMemberId(memberId);
        planItem.setId(id);
        return planItemMapper.deleteByPlan(planItem);
    }

    @Override
    public List<PlanItem> getItemList(Long memberId, List<Long> planIds) {
        return planItemMapper.selectByPlanIds(memberId, planIds);
    }

    /**
     * 根据用户id，运动或食品id获取计划中的sf
     * @param planItem
     * @return
     */
    private PlanItem getPlanItem(PlanItem planItem){
        PlanItem plan= new PlanItem();
        plan.setMemberId(planItem.getMemberId());
        plan.setSfId(planItem.getSfId());
        List<PlanItem> itemList = planItemMapper.selectByPlan(plan);
        if (!CollectionUtils.isEmpty(itemList)) {
            return itemList.get(0);
        }
        return null;
    }
}
