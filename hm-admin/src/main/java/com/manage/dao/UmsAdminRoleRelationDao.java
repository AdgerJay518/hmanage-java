package com.manage.dao;

import com.manage.model.UmsAdminRoleRelation;
import com.manage.model.UmsResource;
import com.manage.model.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色关系管理自定义Dao
 * @author 吴政杰
 */
@Mapper
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);
    /**
     * 获取所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);
    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
