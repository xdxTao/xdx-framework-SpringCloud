package com.xdx97.framework.config.security;

import com.alibaba.fastjson.JSON;
import com.xdx97.framework.common.AjaxResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录
 */
@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        // 从这里拿到token 然后把这个token注销
        String token = httpServletRequest.getHeader("xdxToken");

        // 去redis删除token

        System.out.println("123123213");


        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(100)
                .setErrDesc("退出成功!");

        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}