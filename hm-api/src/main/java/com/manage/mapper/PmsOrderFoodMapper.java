package com.manage.mapper;

import com.manage.model.PmsOrderFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsOrderFoodMapper {
    void insert(PmsOrderFood pmsOrderFood);

    List<PmsOrderFood> selectByPmsOrder(PmsOrderFood pmsOrderFood);

    List<Long> getOrderId(PmsOrderFood pmsOrderFood);
}
