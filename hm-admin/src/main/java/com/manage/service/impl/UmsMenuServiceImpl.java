package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.UmsMenuMapper;
import com.manage.model.UmsMenu;
import com.manage.service.UmsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台菜单管理Service实现类
 * Created by jonyon on 2021/6/27.
 */
@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Autowired
    private UmsMenuMapper umsMenuMapper;

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return umsMenuMapper.selectByParentId(parentId);
    }
}
