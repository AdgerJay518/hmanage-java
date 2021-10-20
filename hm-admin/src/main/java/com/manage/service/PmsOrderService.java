package com.manage.service;

import com.manage.dto.PmsOrderDetail;
import com.manage.dto.PmsOrderQueryParam;
import com.manage.model.PmsOrder;

import java.util.List;

public interface PmsOrderService {
    List<PmsOrder> list(PmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    PmsOrderDetail detail(Long id);
}
