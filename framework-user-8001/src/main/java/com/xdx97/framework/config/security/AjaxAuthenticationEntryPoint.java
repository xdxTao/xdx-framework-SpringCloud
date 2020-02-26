package com.xdx97.framework.config.security;

import com.alibaba.fastjson.JSON;
import com.xdx97.framework.common.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户没有登录时返回给前端的数据
 */
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        AjaxResult ajaxResult = new AjaxResult().setSuccess(false);

        String flagName = httpServletRequest.getAttribute("flagName").toString();

        if (flagName.equals("未登录")){
            ajaxResult.setCode(401)
                    .setErrDesc("未登录，请登录!");
        } else if (flagName.equals("权限不足")){
            ajaxResult.setCode(403)
                    .setErrDesc("权限不足!");
        } else{
            ajaxResult.setCode(000)
                    .setErrDesc("系统异常!");
        };

        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}