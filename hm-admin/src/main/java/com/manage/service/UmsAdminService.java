package com.manage.service;

import com.manage.model.UmsAdmin;
import com.manage.model.UmsResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 用户管理Service
 * @author 吴政杰
 */
public interface UmsAdminService {
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
}
