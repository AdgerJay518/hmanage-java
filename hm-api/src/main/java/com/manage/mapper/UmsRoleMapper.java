package com.manage.mapper;

import com.manage.model.UmsRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UmsRoleMapper {
    List<UmsRole> selectByRole(UmsRole example);
}
