package com.xdx97.framework.config.security;

import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.utils.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component("rbacauthorityservice")
public class RbacAuthorityService {

    @Autowired
    private Environment env;

    public boolean hasPermission(HttpServletRequest request,Authentication authentication) {

        // 获取当前请求的接口
        String requestURI = request.getRequestURI();
        // 放开登录url
        if (requestURI.equals("/user/login")){
            return true;
        }

        // 获取当前请求的菜单
        String menuId = request.getHeader("menuId");

        // 登录判断
        String token = request.getHeader("X-Token");
        if (token == null){
            request.setAttribute("flagName","未登录");
            return false;
        }
        User user = (User) RedisUtils.get(token);
        if (user == null){
            request.setAttribute("flagName","未登录");
            return false;
        }
        // 权限判断,利用token去Redis取出当前角色的权限
        List<String> roles = (List<String>)RedisUtils.get(user.getRoleId());
        if (roles == null || !roles.contains(menuId)){
            request.setAttribute("flagName","权限不足");
            return false;
        }
        return true;
    }
}