package com.manage.mapper;

import com.manage.model.PmsOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsOrderMapper {

    List<PmsOrder> selectByPmsOrder(PmsOrder pmsOrder);

    List<Long>  getOrderId(PmsOrder pmsOrder);

    void insert(PmsOrder order);

    int updateByPrimaryKeySelective(PmsOrder order);

    int deleteByIds(List<Long> ids);

}
