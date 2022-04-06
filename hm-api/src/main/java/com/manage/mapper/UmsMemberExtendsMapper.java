package com.manage.mapper;

import com.manage.model.UmsMemberExtends;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsMemberExtendsMapper {
    UmsMemberExtends getExtendsInfo(Long id);

    int update(UmsMemberExtends umsMemberExtends);
}
