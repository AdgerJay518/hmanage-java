package com.manage.dao;


import com.manage.dto.PmsOrderDetail;
import com.manage.dto.PmsOrderQueryParam;
import com.manage.model.PmsOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PmsOrderDao {
    List<PmsOrder> getList(@Param("queryParam") PmsOrderQueryParam queryParam);

    PmsOrderDetail getDetail(Long id);
}
