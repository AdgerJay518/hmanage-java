package com.manage.service.impl;

import com.manage.domin.MemberDetails;
import com.manage.mapper.UmsMemberMapper;
import com.manage.model.UmsMember;
import com.manage.service.UmsMemberService;
import com.manage.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonyon on 2021/9/8.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UmsMember getByUsername(String username) {
        List<UmsMember> byUsername = umsMemberMapper.getByUsername(username);
        if (byUsername!=null&&byUsername.size()>0){
            UmsMember umsMember = byUsername.get(0);
            return umsMember;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsMember byUsername = getByUsername(username);
        if (byUsername!=null){
            return new MemberDetails(byUsername);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public String login(String username, String password) {
        String token=null;
        try{
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码错误");
            }
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (AuthenticationException e){
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public UmsMember getCurrentMember() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        MemberDetails principal = (MemberDetails)authentication.getPrincipal();
        return principal.getUmsMember();
    }

    @Override
    public int update(UmsMember member) {
        return umsMemberMapper.update(member);
    }
}
