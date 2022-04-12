package com.manage.mapper;

import com.manage.model.PmsOrderFood;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsOrderFoodMapper {
    void insert(PmsOrderFood pmsOrderFood);
}
