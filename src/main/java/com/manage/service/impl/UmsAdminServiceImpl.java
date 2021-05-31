package com.manage.service.impl;

import com.manage.mapper.UmsAdminMapper;
import com.manage.pojo.UmsAdmin;
import com.manage.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理Service实现类
 * @author 吴政杰
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    private UmsAdminMapper mapper;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return mapper.getAdminByUsername(username);
    }
}
