package com.manage.dao;

import com.manage.dto.SmsSportResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsSportDao {
    SmsSportResult getUpdateInfo(Long id);
}
