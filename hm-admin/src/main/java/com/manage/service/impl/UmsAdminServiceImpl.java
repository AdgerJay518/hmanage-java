package com.manage.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.manage.bo.AdminUserDetails;
import com.manage.common.exception.Asserts;
import com.manage.dao.UmsAdminRoleRelationDao;
import com.manage.dto.UmsAdminParam;
import com.manage.mapper.UmsAdminMapper;
import com.manage.model.UmsAdmin;
import com.manage.model.UmsResource;
import com.manage.service.UmsAdminCacheService;
import com.manage.service.UmsAdminService;
import com.manage.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户管理Service实现类
 * @author 吴政杰
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin admin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam,admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        List<UmsAdmin> adminByUsername = umsAdminMapper.getAdminByUsername(admin.getUsername());
        if (adminByUsername.size()>0){
            return null;
        }
        String encode = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encode);
        umsAdminMapper.insert(admin);
        return admin;
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin admin = adminCacheService.getAdmin(username);
        if (admin!=null){
            return admin;
        }
        List<UmsAdmin> adminByUsername = umsAdminMapper.getAdminByUsername(username);
        if (adminByUsername!=null&&adminByUsername.size()>0){
            UmsAdmin umsAdmin = adminByUsername.get(0);
            adminCacheService.setAdmin(umsAdmin);
            return umsAdmin;
        }
        return null;
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = adminCacheService.getResourceList(adminId);
        if (CollUtil.isNotEmpty(resourceList)){
            return resourceList;
        }
        resourceList = adminRoleRelationDao.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            adminCacheService.setResourceList(adminId,resourceList);
        }
        return resourceList;
    }

    @Override
    public String login(String username, String password) {
        String token=null;
        try{
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authenticationToken=
                    new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsAdmin adminByUsername = getAdminByUsername(username);
        if (adminByUsername!=null){
            List<UmsResource> resourceList = getResourceList(adminByUsername.getId());
            return new AdminUserDetails(adminByUsername,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        UmsAdmin umsAdmin = umsAdminMapper.selectByPrimaryKey(id);
        if (umsAdmin.getPassword().equals(admin.getPassword())){
            admin.setPassword(null);
        }
        else{
            if (StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            }else {
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
        }
        int update = umsAdminMapper.updateByPrimaryKeySelective(admin);
        adminCacheService.delAdmin(id);
        return update;
    }

    @Override
    public UmsAdmin getById(Long id) {
        return umsAdminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        adminCacheService.delAdmin(id);
        int count = umsAdminMapper.deleteByPrimaryKey(id);
        adminCacheService.delResourceList(id);
        return count;
    }
}
