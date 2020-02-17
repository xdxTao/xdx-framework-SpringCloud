package com.xdx97.framework.service.impl;


import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.User;
import com.xdx97.framework.mapper.UserMapper;
import com.xdx97.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AjaxResult<List<User>> selectList() {

        List<User> xUsers = userMapper.selectList(null);
        return AjaxResult.success(xUsers.size() ,xUsers);
    }

    @Override
    public User getById(String id) {

        User user = userMapper.selectById(id);
        return user;
    }
}