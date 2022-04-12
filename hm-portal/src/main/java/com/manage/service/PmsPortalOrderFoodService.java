package com.manage.service;

import com.manage.common.api.CommonPage;
import com.manage.domin.PmsOrderFoodDetail;
import com.manage.dto.OrderFoodParam;

import java.util.Map;

public interface PmsPortalOrderFoodService {
    Map<String, Object> generateOrder(OrderFoodParam orderFoodParam);

    CommonPage<PmsOrderFoodDetail> list(Integer status, Integer pageNum, Integer pageSize);
}
