package com.xdx97.framework.config.security;

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

        // 获取当前请求的URI
        String requestURI = request.getRequestURI();

        System.out.println("requestURI 2 ; " + requestURI);

        // 放开登录url
        if (requestURI.equals("/user/login")){
            return true;
        }

        // 登录判断
        String token = request.getHeader("X-Token");
        if (token == null || RedisUtils.get(token) == null){
            request.setAttribute("flagName","未登录");
            return false;
        }

        // 权限判断
        // 利用token去Redis取出当前角色的权限,这里就直接写死了
        List<String> roles = new ArrayList<>();
        roles.add("/user/list");
        roles.add("/authority/menu/list");
        roles.add("/user/loginOut");
        roles.add("/authority/role/list");
        roles.add("/authority/list");
        roles.add("/authority/listbyroleId");
        if (!roles.contains(requestURI)){
            request.setAttribute("flagName","权限不足");
            return false;
        }
        return true;
    }
}