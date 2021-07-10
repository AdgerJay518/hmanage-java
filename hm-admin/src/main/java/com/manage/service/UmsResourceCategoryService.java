package com.manage.service;

import com.manage.model.UmsResourceCategory;

import java.util.List;

/**
 * 资源分类管理Service
 * @author 吴政杰
 */
public interface UmsResourceCategoryService {
    /**
     * 获取所有资源分类
     */
    List<UmsResourceCategory> listAll();

    /**
     *修更新后台资源分类
     */
    int update(Long id,UmsResourceCategory umsResourceCategory);

    /**
     *创建新的后台资源分类
     */
    int create(UmsResourceCategory umsResourceCategory);

    /**
     *根据id删除后台资源
     */
    int delete(Long id);
}
