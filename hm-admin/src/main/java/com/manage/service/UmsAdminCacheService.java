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
}
