package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.UmsRoleDao;
import com.manage.mapper.UmsRoleMapper;
import com.manage.model.UmsMenu;
import com.manage.model.UmsRole;
import com.manage.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *角色管理Service实现类
 * @author jonyon
 * @date 2021/6/22
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleDao roleDao;
    @Autowired
    private UmsRoleMapper umsRoleMapper;

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<UmsRole> list() {
        return umsRoleMapper.selectByRole(new UmsRole());
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        UmsRole umsRole = new UmsRole();
        if (!StringUtils.isEmpty(keyword)){
            umsRole.setName("%"+keyword+"%");
        }
        return umsRoleMapper.getByLikeName(umsRole.getName());
    }
}
