package com.manage.mapper;

import com.manage.model.UmsRoleMenuRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsRoleMenuRelationMapper {
    /**
     * 根据id删除角色菜单关系
     * @param id
     * @return
     */
    int deleteRelationById(Long id);

    /**
     * 批量插入新关系
     * @param umsRoleMenuRelation
     * @return
     */
    int insert(UmsRoleMenuRelation umsRoleMenuRelation);
}
