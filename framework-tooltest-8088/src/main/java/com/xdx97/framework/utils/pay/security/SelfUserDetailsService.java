package com.xdx97.framework.utils.pay.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 *  ② 根据 username 获取数据库 user 信息
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //构建用户信息的逻辑(取数据库/LDAP等用户信息)
        SelfUserDetails userInfo = new SelfUserDetails();
        // 任意用户名登录
        userInfo.setUsername(username);

//        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
//        // 模拟从数据库中获取的密码原为 123
//        String encodePassword = md5PasswordEncoder.encodePassword("123", username);

        userInfo.setPassword("123");

        Set authoritiesSet = new HashSet();
        // 模拟从数据库中获取用户角色
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");

        authoritiesSet.add(authority);
        userInfo.setAuthorities(authoritiesSet);

        return userInfo;
    }
}