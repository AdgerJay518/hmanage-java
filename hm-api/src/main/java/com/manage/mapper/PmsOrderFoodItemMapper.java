package com.manage.mapper;

import com.manage.model.PmsOrderFoodItem;
import com.manage.model.PmsOrderItemExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsOrderFoodItemMapper {
    List<PmsOrderFoodItem> selectByPmsOrderItem(PmsOrderItemExample pmsOrderItem);
}
