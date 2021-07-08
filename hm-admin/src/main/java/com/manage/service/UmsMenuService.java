package com.manage.service;

import com.manage.dto.UmsMenuNode;
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

    /**
     * 返回树形结构菜单列表
     */
    List<UmsMenuNode> treeList();

    /**
     * 菜单是否显示
     */
    int updateHidden(Long id, Integer hidden);

    /**
     * 根据id获取菜单详
     */
    UmsMenu getItem(Long id);

    /**
     *更新菜单
     */
    int update(Long id,UmsMenu umsMenu);

    /**
     *修改菜单级别
     */
    void updateLevel(UmsMenu umsMenu);

    /**
     *新建后台菜单
     */
    int create(UmsMenu umsMenu);

    /**
     * 根据id删除菜单
     */
    int delete(Long id);
}
