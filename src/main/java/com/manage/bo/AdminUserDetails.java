package com.manage.bo;

import com.manage.pojo.UmsAdmin;
import com.manage.pojo.UmsResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * @author 吴政杰
 */
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsResource> resourceList;
    public AdminUserDetails(UmsAdmin umsAdmin,List<UmsResource> resourceList) {
        this.umsAdmin = umsAdmin;
        this.resourceList = resourceList;
    }

    /**
     * 获取当前用户的角色
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> list=new ArrayList<>();
//        for (UmsResource resource:resourceList){
//            list.add(new SimpleGrantedAuthority(resource.getId()+":"+resource.getName()));
//        }
//        return list;
        return resourceList.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }

    /**
     * 获取当前用户的密码
     */
    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    /**
     * 获取当前用户的用户名
     */
    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    /**
     *当前账户是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *当前账户是否锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *当前凭证是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     *当前账户是否可用
     */
    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
