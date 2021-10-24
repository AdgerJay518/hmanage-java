package com.manage.mapper;

import com.manage.model.FmsFood;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FmsFoodMapper {
    FmsFood selectByPrimaryKey(Long id);

    void updateFood(FmsFood fmsFood);
}
