package com.manage.dao;

import com.manage.dto.manageParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PortalOrderDao {
    List<manageParam> getCalorie(String startTime,String endTime);
}
