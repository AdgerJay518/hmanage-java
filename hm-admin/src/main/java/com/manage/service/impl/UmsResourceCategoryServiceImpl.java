package com.manage.service.impl;

import com.manage.mapper.UmsResourceCategoryMapper;
import com.manage.model.UmsResourceCategory;
import com.manage.service.UmsResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源分类管理Service实现类
 * Created by jonyon on 2021/6/27.
 */
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
    @Autowired
    private UmsResourceCategoryMapper umsResourceCategoryMapper;

    @Override
    public List<UmsResourceCategory> listAll() {
        return umsResourceCategoryMapper.selectAll();
    }
}
