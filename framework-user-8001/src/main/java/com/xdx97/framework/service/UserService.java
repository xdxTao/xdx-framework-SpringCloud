package com.xdx97.framework.service;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.entitys.vo.user.UserVo;

import java.util.List;

public interface UserService {

    /**
     * 获取用户列表
     *
     * @param page 当前页
     * @param user 条件查询
     * @return List<User> 用户列表
     */
    AjaxResult<List<User>> selectList(int page,User user);

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
    AjaxResult<List<UserVo>> userDtoList();
}