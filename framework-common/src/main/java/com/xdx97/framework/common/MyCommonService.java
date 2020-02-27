package com.xdx97.framework.common;

import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.utils.primarykeysnowflake.PrimaryKeySnowflakeGenerator;
import com.xdx97.framework.utils.redis.RedisUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这里面封装一些Service公用的方法
 */
@Component
public class MyCommonService {


    /**
     * 获取当前用户的雪花算法key
     * @param o
     * @return
     */
    public String getSnowflakeKey(Object o){

        PrimaryKeySnowflakeGenerator primaryKeySnowflake = new PrimaryKeySnowflakeGenerator();
        return primaryKeySnowflake.generate(o);
    }

    public User getCurUser(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
//        HttpServletResponse response = servletRequestAttributes.getResponse();
        return (User)RedisUtils.get(request.getHeader("X-Token"));
    }

}
