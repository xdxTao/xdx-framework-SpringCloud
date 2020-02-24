package com.xdx97.framework.utils.pay.security;

import com.alibaba.fastjson.JSON;
import com.xdx97.framework.common.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.security.web.AuthenticationEntryPoint;

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
        AjaxResult ajaxResult = new AjaxResult();

        ajaxResult.setCode(888)
                .setErrDesc("未登录，请登录!");

        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}