package com.manage.mapper;


import com.manage.model.PlanItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanItemMapper {
    List<PlanItem> selectByPlan(PlanItem plan);

    int insert(PlanItem planItem);

    int updateByPrimaryKey(PlanItem existPlanItem);

    int updateBySfAndMemberId(PlanItem planItem);

    int deleteByPlan(PlanItem planItem);

    List<PlanItem> selectByPlanIds(Long memberId, List<Long> planIds);

    int deleteByIds(Long memberId, List<Long> planIds);
}
