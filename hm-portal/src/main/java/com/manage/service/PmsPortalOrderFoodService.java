package com.manage.service;

import com.manage.dto.OrderFoodParam;

import java.util.Map;

public interface PmsPortalOrderFoodService {
    Map<String, Object> generateOrder(OrderFoodParam orderFoodParam);
}
