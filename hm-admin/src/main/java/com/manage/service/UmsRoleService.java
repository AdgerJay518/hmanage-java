package com.manage.service;

import com.manage.model.UmsMenu;
import com.manage.model.UmsRole;

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

    /**
     * 获取所有角色列表
     */
    List<UmsRole> list();

    List<UmsRole> list(String keyword,Integer pageSize,Integer pageNum);
}
