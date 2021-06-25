package com.manage.service.impl;

import com.manage.mapper.UmsResourceMapper;
import com.manage.model.UmsResource;
import com.manage.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public List<UmsResource> listAll() {
        return resourceMapper.selectByResource(new UmsResource());
    }
}