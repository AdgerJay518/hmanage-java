package com.manage.mapper;

import com.manage.model.FmsFood;
import com.manage.model.SmsSport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FmsFoodMapper {
    FmsFood selectByPrimaryKey(Long id);

    void updateFood(FmsFood fmsFood);

    List<FmsFood> selectByFood(FmsFood fmsFood);

    void updateByPrimaryKeySelective(FmsFood fmsFood);

    void insertSelective(FmsFood fmsFood);

    int deleteByIds(List<Long> ids);

    int updateStatusByIds(Integer recommendStatus, List<Long> ids);
}
