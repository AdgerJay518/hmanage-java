package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dto.UmsMenuNode;
import com.manage.mapper.UmsMenuMapper;
import com.manage.model.UmsMenu;
import com.manage.service.UmsMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = umsMenuMapper.selectByUmsMenu(new UmsMenu());
        List<UmsMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        return umsMenuMapper.updateByUmsMenu(umsMenu);
    }

    @Override
    public UmsMenu getItem(Long id) {
        return umsMenuMapper.selectById(id);
    }

    @Override
    public int update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        updateLevel(umsMenu);
        return umsMenuMapper.updateByUmsMenu(umsMenu);
    }

    @Override
    public void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId()==0){
            //没有父级菜单时为一级菜单
            umsMenu.setLevel(0);
        }
        else{
            UmsMenu parentMenu = umsMenuMapper.selectById(umsMenu.getParentId());
            //如果父级菜单存在，菜单级数+1
            if (parentMenu!=null){
                umsMenu.setLevel(parentMenu.getLevel()+1);
            }else {
                //如果父级菜单不存在，该菜单为一级菜单
                umsMenu.setLevel(0);
            }
        }
    }

    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        updateLevel(umsMenu);
        return umsMenuMapper.insert(umsMenu);
    }

    @Override
    public int delete(Long id) {
        return umsMenuMapper.delete(id);
    }

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
