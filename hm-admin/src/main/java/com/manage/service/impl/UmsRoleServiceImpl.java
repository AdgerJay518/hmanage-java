package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.UmsRoleDao;
import com.manage.mapper.UmsRoleMapper;
import com.manage.mapper.UmsRoleMenuRelationMapper;
import com.manage.model.UmsMenu;
import com.manage.model.UmsRole;
import com.manage.model.UmsRoleMenuRelation;
import com.manage.service.UmsAdminCacheService;
import com.manage.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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
    @Autowired
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
    @Autowired
    private UmsAdminCacheService adminCacheService;

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

    @Override
    public int update(long id, UmsRole umsRole) {
        umsRole.setId(id);
        return umsRoleMapper.updateByUmsRole(umsRole);
    }

    @Override
    public int create(UmsRole umsRole) {
        umsRole.setCreateTime(new Date());
        umsRole.setAdminCount(0);
        umsRole.setSort(0);
        return umsRoleMapper.create(umsRole);
    }

    @Override
    public int delete(Long id) {
        int count = umsRoleMapper.deleteByPrimaryKey(id);
        adminCacheService.delResourceListByRoleIds(id);
        return count;
    }

    @Override
    public List<UmsMenu> listMenu(Long id) {
        return roleDao.getMenuListByRoleId(id);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //删除原有关系
        roleMenuRelationMapper.deleteRelationById(roleId);
        //建立新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation umsRoleMenuRelation = new UmsRoleMenuRelation();
            umsRoleMenuRelation.setRoleId(roleId);
            umsRoleMenuRelation.setMenuId(menuId);
            roleMenuRelationMapper.insert(umsRoleMenuRelation);
        }
        return menuIds.size();
    }
}
