package com.manage.mapper;

import com.manage.model.UmsRoleResourceRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsRoleResourceRelationMapper {
    /**
     * 根据id删除角色资源关系
     * @param id
     * @return
     */
    int deleteRRRelationById(Long id);

    /**
     * 批量插入新关系
     * @param umsRoleMenuRelation
     * @return
     */
    int insert(UmsRoleResourceRelation umsRoleMenuRelation);
}
