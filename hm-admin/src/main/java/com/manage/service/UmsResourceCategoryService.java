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
}
