package com.xdx97.framework.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.common.MyCommonService;
import com.xdx97.framework.entitys.dto.user.UserDto;
import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.mapper.UserMapper;
import com.xdx97.framework.service.UserService;
import com.xdx97.framework.utils.UUIDUtils;
import com.xdx97.framework.utils.redis.RedisUtils;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends MyCommonService
            implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AjaxResult<List<User>> selectList(int page,User user) {

        startPage(page);
        Page<User> xUsers = userMapper.list(user);
        return AjaxResult.success(xUsers.getResult()).setTotal(xUsers.getTotal());
    }

    @Override
    public User getById(String id) {

        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public AjaxResult<?> login(User user) {
        AjaxResult ajaxResult = new AjaxResult();
        User userTmp = userMapper.selectOne(new User().setUserName(user.getUserName()));
        if (userTmp == null || !userTmp.getUserPassword().equals(user.getUserPassword())){
            ajaxResult.setCode(222).setErrDesc("用户名或密码错误!").setSuccess(false);
            return ajaxResult;
        }
        String  xdxToken = UUIDUtils.getUUID();
        // 3、如果验证成功了，就返回 token
        userTmp.setOpenid(xdxToken);
        ajaxResult.setCode(200).setMsg("登录成功!").setXdxToken(xdxToken).setData(userTmp).setSuccess(true);
        RedisUtils.set(xdxToken,userTmp,30L);
        return ajaxResult;
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public AjaxResult<?> userSave(User user) {

        user.setUserId(getSnowflakeKey(user))
                .setUserPassword("123456")
                .setSalt("123456")
                .setUserCreate("1")
                .setGmtCreate(new Date());
        userMapper.insert(user);
        return AjaxResult.success("新增成功");
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public AjaxResult<?> userUpdate(User user) {
        user.setUserModified(getCurUser().getUserId())
                .setGmtModified(new Date());
        userMapper.updateById(user);
        return AjaxResult.success("更新成功");
    }

    /**
     * userDto 列表
     * @return
     */
    @Override
    public AjaxResult<List<UserDto>> userDtoList() {

        List<UserDto> lists = userMapper.userDtoList();

        return AjaxResult.success(lists);
    }
}