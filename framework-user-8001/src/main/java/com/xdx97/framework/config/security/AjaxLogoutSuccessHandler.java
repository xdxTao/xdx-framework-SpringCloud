package com.xdx97.framework.config.security;

import com.alibaba.fastjson.JSON;
import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.utils.redis.RedisUtils;
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
        AjaxResult ajaxResult = new AjaxResult();
        // 从这里拿到token 然后把这个token注销
        String token = httpServletRequest.getHeader("X-Token");
        // 去redis删除token
        if (token != null && !token.equals("")){
            RedisUtils.remove(token);
            ajaxResult.setCode(100)
                    .setErrDesc("退出成功!");
        }else{
            ajaxResult.setCode(500)
                    .setErrDesc("系统异常!");
        }



        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}