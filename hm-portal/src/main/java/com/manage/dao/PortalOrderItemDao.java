package com.manage.dao;


import com.manage.model.PmsOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PortalOrderItemDao {
    void insertList(@Param(value="orderItem") List<PmsOrderItem> list);
}
