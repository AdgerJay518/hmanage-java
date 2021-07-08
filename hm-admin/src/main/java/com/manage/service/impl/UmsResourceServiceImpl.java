package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.UmsResourceMapper;
import com.manage.model.UmsResource;
import com.manage.model.UmsRole;
import com.manage.service.UmsAdminCacheService;
import com.manage.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *资源管理Service实现类
 * @author jonyon
 * @date 2021/6/21
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {
    @Autowired
    private UmsResourceMapper resourceMapper;
    @Autowired
    private UmsAdminCacheService cacheService;
    /**
     * 查询所有资源
     * @return
     */
    @Override
    public List<UmsResource> listAll() {
        return resourceMapper.selectByResource(new UmsResource());
    }

    /**
     * 分页查询
     * @param categoryId
     * @param nameKeyword
     * @param urlKeyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        UmsResource umsResource = new UmsResource();
        if (categoryId!=null){
            umsResource.setCategoryId(categoryId);
        }
        if (!StringUtils.isEmpty(nameKeyword)){
            umsResource.setName("%"+nameKeyword+"%");
        }
        if (!StringUtils.isEmpty(urlKeyword)){
            umsResource.setUrl("%"+urlKeyword+"%");
        }
        return resourceMapper.selectByResource(umsResource);
    }

    @Override
    public int update(Long id, UmsResource umsResource) {
        umsResource.setId(id);
        int i = resourceMapper.updateByUmsResource(umsResource);
        cacheService.delResourceListByResource(id);
        return i;
    }


}
