package com.xdx97.framework.utils.pay.security;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.xdx97.framework.common.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录失败时返回给前端的数据
 */
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(400)
                .setErrDesc("登录失败!");

        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}
