package com.xdx97.framework.service.impl;


import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.mapper.UserMapper;
import com.xdx97.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AjaxResult<List<User>> selectList() {

        List<User> xUsers = userMapper.selectList(null);
        return AjaxResult.success(xUsers);
    }

    @Override
    public User getById(String id) {

        User user = userMapper.selectById(id);
        return user;
    }

    @Autowired
    private Environment env;

    @Override
    public AjaxResult<?> login(User user) {
        AjaxResult ajaxResult = new AjaxResult();
        /**
         * 1、获取到了用户名和密码去进行判断是否正确
         * 2、如果验证不成功，这里我默认用户名密码必须等于 admin admin
         */
        if (! ("admin".equals(user.getUserName()) && "admin".equals(user.getUserPassword()))){
            ajaxResult.setCode(222).setErrDesc("用户名或密码错误!");
            return ajaxResult;
        }

        // 3、如果验证成功了，就返回 token，当然了我们现需要把token存入Redis这里就省略了
        ajaxResult.setCode(200).setMsg("登录成功!").setXdxToken(env.getProperty("xdxToken"));

        return ajaxResult;
    }
}