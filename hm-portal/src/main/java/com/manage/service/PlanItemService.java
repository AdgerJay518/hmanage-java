package com.manage.service;


import com.manage.model.PlanItem;

import java.util.List;

public interface PlanItemService {
    int add(PlanItem planItem);

    List<PlanItem> list(Long id);

    int updateQuantity(Long id, Long memberId, Integer quantity);

    int delete(Long memberId, Long id);

    List<PlanItem> getItemList(Long memberId, List<Long> planIds);

    int deletes(Long id, List<Long> planIds);
}
