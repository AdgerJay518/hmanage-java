package com.manage.dao;

import com.manage.dto.FmsFoodResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FmsFoodDao {
    FmsFoodResult getUpdateInfo(Long id);
}
