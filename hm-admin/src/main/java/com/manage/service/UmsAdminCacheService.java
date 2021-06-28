package com.manage.service;

import com.manage.model.UmsAdmin;
import com.manage.model.UmsResource;

import java.util.List;

/**
 * 用户缓存操作Service
 * @author 吴政杰
 */
public interface UmsAdminCacheService {
    /**
     * 获取缓存后台用户资源列表
     */
    List<UmsResource> getResourceList(Long adminId);
    /**
     * 设置缓存后台用户资源列表
     */
    void setResourceList(Long adminId, List<UmsResource> resourceList);
    /**
     * 删除后台用户资源列表缓存
     */
    void delResourceList(Long adminId);
    /**
     * 获取缓存后台用户信息
     */
    UmsAdmin getAdmin(String username);
    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(UmsAdmin admin);
    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);
    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRoleIds(Long id);
}
