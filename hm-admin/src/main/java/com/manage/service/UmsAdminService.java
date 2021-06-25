package com.manage.service;

import com.manage.dto.UmsAdminParam;
import com.manage.model.UmsAdmin;
import com.manage.model.UmsResource;
import com.manage.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户管理Service
 * @author 吴政杰
 */
public interface UmsAdminService {

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     *根据用户名获得管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取指定用户的可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的Token
     */
    String login(String username,String password);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 根据用户id获取用户
     */
    UmsAdmin getById(Long id);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 根据用户名分页查询用户
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 获取用户对应角色
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 修改用户角色
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleId);
}
