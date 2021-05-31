package com.manage.service;

import com.manage.pojo.UmsAdmin;

/**
 * 用户管理Service
 * @author 吴政杰
 */
public interface UmsAdminService {
    /**
     *根据用户名获得管理员
     */
    UmsAdmin getAdminByUsername(String username);
}
