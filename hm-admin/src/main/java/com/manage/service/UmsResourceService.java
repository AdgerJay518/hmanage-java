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
}
