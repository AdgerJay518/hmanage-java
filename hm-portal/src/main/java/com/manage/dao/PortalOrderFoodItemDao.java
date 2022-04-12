package com.manage.dao;

import com.manage.model.PmsOrderFoodItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PortalOrderFoodItemDao {
    void insertList(@Param(value="orderFoodItem") List<PmsOrderFoodItem> list);
}
