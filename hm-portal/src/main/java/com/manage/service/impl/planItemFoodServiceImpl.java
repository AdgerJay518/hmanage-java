package com.manage.service.impl;

import com.manage.mapper.PlanItemFoodMapper;
import com.manage.model.PlanItemFood;
import com.manage.model.UmsMember;
import com.manage.service.PlanItemFoodService;
import com.manage.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class planItemFoodServiceImpl implements PlanItemFoodService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private PlanItemFoodMapper planItemFoodMapper;

    @Override
    public int add(PlanItemFood planItemFood) {
        int count;
        UmsMember currentMember =memberService.getCurrentMember();
        planItemFood.setMemberId(currentMember.getId());
        planItemFood.setMemberNickname(currentMember.getNickname());
        planItemFood.setDeleteStatus(0);
        PlanItemFood existPlanItem = getPlanItem(planItemFood);
        if (existPlanItem==null){
            planItemFood.setCreateDate(new Date());
            count=planItemFoodMapper.insert(planItemFood);
        }
        else{
            planItemFood.setModifyDate(new Date());
            existPlanItem.setQuantity(existPlanItem.getQuantity()+planItemFood.getQuantity());
            count = planItemFoodMapper.updateByPrimaryKey(existPlanItem);
        }
        return count;
    }

    @Override
    public List<PlanItemFood> list(Long id) {
        PlanItemFood planItemFood = new PlanItemFood();
        planItemFood.setMemberId(id);
        return planItemFoodMapper.selectByPlan(planItemFood);
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
        PlanItemFood planItemFood = new PlanItemFood();
        planItemFood.setQuantity(quantity);
        planItemFood.setId(id);
        planItemFood.setMemberId(memberId);
        return planItemFoodMapper.updateBySfAndMemberId(planItemFood);
    }

    @Override
    public int delete(Long memberId, Long id) {
        PlanItemFood planItemFood = new PlanItemFood();
        planItemFood.setMemberId(memberId);
        planItemFood.setId(id);
        return planItemFoodMapper.deleteByPlan(planItemFood);
    }

    private PlanItemFood getPlanItem(PlanItemFood planItemFood){
        PlanItemFood planItem = new PlanItemFood();
        planItem.setMemberId(planItemFood.getMemberId());
        planItem.setFoodId(planItemFood.getFoodId());
        List<PlanItemFood> itemList = planItemFoodMapper.selectByPlan(planItem);
        if (!CollectionUtils.isEmpty(itemList)) {
            return itemList.get(0);
        }
        return null;
    }
}
