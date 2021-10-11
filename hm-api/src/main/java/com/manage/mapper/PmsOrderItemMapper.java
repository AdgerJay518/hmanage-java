package com.manage.mapper;

import com.manage.model.PmsOrderItem;
import com.manage.model.PmsOrderItemExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PmsOrderItemMapper {
    List<PmsOrderItem> selectByPmsOrderItem(PmsOrderItemExample pmsOrderItem);

}
