package com.manage.mapper;

import com.manage.model.UmsAdmin;
import com.manage.model.UmsMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UmsMemberMapper {

    List<UmsMember> getByUsername(String username);

    int update(UmsMember member);
}
