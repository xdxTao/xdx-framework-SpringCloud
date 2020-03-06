package com.xdx97.framework.service;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.dto.user.UserDto;
import com.xdx97.framework.entitys.pojo.user.User;

import java.util.List;

public interface UserService {

    AjaxResult<List<User>> selectList();

    User getById(String id);

    AjaxResult<?> login(User user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    AjaxResult<?> userSave(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    AjaxResult<?> userUpdate(User user);

    /**
     * userDto 列表
     * @return
     */
    AjaxResult<List<UserDto>> userDtoList();
}