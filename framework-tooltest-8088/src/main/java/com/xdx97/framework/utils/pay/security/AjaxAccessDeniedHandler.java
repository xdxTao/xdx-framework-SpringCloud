package com.xdx97.framework.utils.pay.security;

import com.alibaba.fastjson.JSON;
import com.xdx97.framework.common.AjaxResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        AjaxResult ajaxResult = new AjaxResult();

        ajaxResult.setCode(300)
                .setErrDesc("没有访问权限!");
        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}