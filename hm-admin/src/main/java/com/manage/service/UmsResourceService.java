package com.manage.service;

import com.manage.model.UmsResource;

import java.util.List;

/**
 * 资源管理Service
 * @author 吴政杰
 */
public interface UmsResourceService {
    /**
     * 查询全部资源
     */
    List<UmsResource> listAll();

    /**
     * 分页查询
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     *更行资源列表
     */
    int update(Long id, UmsResource umsResource);

    /**
     *添加创建后台资源
     */
    int create(UmsResource umsResource);

    /**
     *根据id删除后台资源
     */
    int delete(Long id);
}
