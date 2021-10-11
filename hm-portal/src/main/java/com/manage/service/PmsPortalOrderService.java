package com.manage.service;

import com.manage.common.api.CommonPage;
import com.manage.domin.PlanItemList;
import com.manage.domin.PmsOrderDetail;
import com.manage.dto.OrderParam;
import com.manage.model.PlanItem;

import java.util.List;
import java.util.Map;

public interface PmsPortalOrderService {
    CommonPage<PmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    Map<String, Object> generateOrder(OrderParam orderParam);

    List<PlanItem> test(OrderParam orderParam);
}
