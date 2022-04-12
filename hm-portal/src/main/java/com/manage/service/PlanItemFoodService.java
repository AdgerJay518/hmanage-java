package com.manage.service;

import com.manage.model.PlanItemFood;

import java.util.List;

public interface PlanItemFoodService {
    int add(PlanItemFood planItemFood);

    List<PlanItemFood> list(Long id);

    int updateQuantity(Long id, Long id1, Integer quantity);

    int delete(Long id, Long id1);

    List<PlanItemFood> getItemFoodList(Long memberId, List<Long> planIds);

    int deletes(Long id, List<Long> planIds);
}
