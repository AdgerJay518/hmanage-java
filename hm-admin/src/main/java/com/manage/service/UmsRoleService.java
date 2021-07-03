package com.manage.service;

import com.manage.model.UmsMenu;
import com.manage.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色管理Service
 * @author 吴政杰
 */
public interface UmsRoleService {
    /**
     * 根据ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 获取所有角色列表
     */
    List<UmsRole> list();

    /**
     * 分页获取角色列表
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsRole> list(String keyword,Integer pageSize,Integer pageNum);

    /**
     * 更新角色信息
     * @param id
     * @param umsRole
     * @return
     */
    int update(long id,UmsRole umsRole);

    /**
     * 创建角色
     * @param umsRole
     * @return
     */
    int create(UmsRole umsRole);

    /**
     * 删除角色
     * @param ids
     * @return
     */
    int delete(Long id);

    /**
     * 获取角色相关菜单
     * @param id
     * @return
     */
    List<UmsMenu> listMenu(Long id);

    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);
}
