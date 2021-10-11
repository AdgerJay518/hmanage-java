package com.manage.service;

import com.manage.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户管理
 * Created by jonyon on 2021/9/8.
 */
public interface UmsMemberService {
    /**
     * 根据用户名获取用户
     */
    UmsMember getByUsername(String username);
    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 登录后获取token
     */
    String login(String username, String password);

    UmsMember getCurrentMember();

    int update(UmsMember member);
}
