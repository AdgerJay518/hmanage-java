package com.manage.mapper;

import com.manage.model.PmsOrderOperateHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsOrderOperateHistoryMapper {
    void insert(PmsOrderOperateHistory history);
}
