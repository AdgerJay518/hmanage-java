package com.manage.mapper;

import com.manage.pojo.UmsAdmin;

/**
 * @author 吴政杰
 */
public interface UmsAdminMapper {
    public UmsAdmin getAdminByUsername(String username);
}
