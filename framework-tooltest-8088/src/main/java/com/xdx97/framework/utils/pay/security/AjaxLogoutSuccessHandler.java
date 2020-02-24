package com.xdx97.framework.utils.pay.security;

import com.alibaba.fastjson.JSON;
import com.xdx97.framework.common.AjaxResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(100)
                .setErrDesc("退出成功!");

        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}