package com.xdx97.framework.utils.pay.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

/**
 * 前端交互
 */
@Component
public class SelfAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    SelfUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // 这个获取表单输入中返回的用户名;
        String userName = (String) authentication.getPrincipal();
        // 这个是表单中输入的密码；
        String password = (String) authentication.getCredentials();


        UserDetails userInfo = userDetailsService.loadUserByUsername(userName);

        if (!userInfo.getPassword().equals(password)) {
            throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
        }

        return new UsernamePasswordAuthenticationToken(userName, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}