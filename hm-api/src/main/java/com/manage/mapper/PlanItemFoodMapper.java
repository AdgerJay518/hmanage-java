package com.manage.mapper;

import com.manage.model.PlanItemFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanItemFoodMapper {
    

    int insert(PlanItemFood planItemFood);

    int updateByPrimaryKey(PlanItemFood existPlanItem);

    List<PlanItemFood> selectByPlan(PlanItemFood planItem);

    int updateBySfAndMemberId(PlanItemFood planItemFood);

    int deleteByPlan(PlanItemFood planItemFood);

    List<PlanItemFood> selectByPlanIds(Long memberId, List<Long> planIds);

    int deleteByIds(Long memberId, List<Long> planIds);
}
