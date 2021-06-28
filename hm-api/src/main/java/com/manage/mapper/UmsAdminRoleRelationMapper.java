package com.manage.mapper;

import com.manage.model.UmsAdminRoleRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 吴政杰
 */
@Mapper
public interface UmsAdminRoleRelationMapper {
    List<UmsAdminRoleRelation> selectByRelation(Long id);
}
