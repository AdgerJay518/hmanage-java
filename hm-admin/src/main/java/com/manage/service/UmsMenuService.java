package com.manage.service;

import com.manage.model.UmsMenu;

import java.util.List;

/**
 * 后台菜单管理Service
 * @author 吴政杰
 */
public interface UmsMenuService {
    /**
     * 分页查询后台菜单
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);
}
