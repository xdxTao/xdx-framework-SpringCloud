package com.xdx97.framework.service;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.user.User;

import java.util.List;

public interface UserService {

    AjaxResult<List<User>> selectList();

    User getById(String id);

    AjaxResult<?> login(User user);
}