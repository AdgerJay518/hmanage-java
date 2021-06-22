package com.manage.service;

import com.manage.model.UmsMenu;

import java.util.List;

/**
 * 角色管理Service
 * @author 吴政杰
 */
public interface UmsRoleService {
    /**
     * 根据ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);
}
