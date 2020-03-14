package com.xdx97.framework.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.dto.user.UserAddDto;
import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.entitys.vo.user.UserVo;
import com.xdx97.framework.service.impl.UserServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户相关的操作
 *
 * @author 小道仙
 * @date 2020年2月27日
 */
@RestController
@Api(tags = "用户相关接口", description = "提供用户相关的 Rest API")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 用户列表
     *
     * @param page 当前页
     * @return List<User> 用户列表
     * @author 小道仙
     * @date 2020年3月13日
     */
    @ApiOperation(value="用户列表" )
    @GetMapping("/user/list")
    public AjaxResult<List<User>> list(
            @ApiParam(value = "当前页", required = true) @RequestParam int page,
            @ApiParam(value = "用户名/用户电话") @RequestParam String userName,
            @ApiParam(value = "角色") @RequestParam String roleId){

        User user = new User();
        user.setUserName(userName).setRoleId(roleId);
        return userServiceImpl.selectList(page,user);
    }

    /**
     * 用户登录
     *
     * @param userName   用户名
     * @param userPassword  密码
     * @author 小道仙
     * @date 2020年3月14
     */
    @ApiOperation(value = "登录", notes = "创建人- 小道仙")
    @GetMapping("/user/login")
    public AjaxResult<?> login(
            @ApiParam(value = "用户名", required = true) @RequestParam String userName,
            @ApiParam(value = "密码", required = true) @RequestParam String userPassword){
        User user = new User();
        user.setUserName(userName).setUserPassword(userPassword);
        return userServiceImpl.login(user);
    }

    /**
     * 新增用户
     *
     * @param userAddDto
     * @author 小道仙
     * @date 2020年3月14
     */
    @PostMapping("/user/save")
    @ApiOperation(value="新增用户", notes = "创建人- 小道仙")
    public AjaxResult<?> userSave(@RequestBody UserAddDto userAddDto){
        User user = new User();
        user.setUserName(userAddDto.getUserName())
                .setUserPhone(userAddDto.getUserPhone())
                .setRoleId(userAddDto.getRoleId())
                .setUserPassword(userAddDto.getUserPassword())
                .setUserStatus(userAddDto.getUserStatus());
        return userServiceImpl.userSave(user);
    }

    /**
     * 更新用户
     *
     * @param userAddDto
     * @author 小道仙
     * @date 2020年3月14
     */
    @PostMapping("/user/update")
    @ApiOperation(value="更新用户", notes = "创建人- 小道仙")
    public AjaxResult<?> userUpdate(@RequestBody UserAddDto userAddDto){
        User user = new User();
        user.setUserName(userAddDto.getUserName())
                .setUserPhone(userAddDto.getUserPhone())
                .setRoleId(userAddDto.getRoleId())
                .setUserPassword(userAddDto.getUserPassword())
                .setUserStatus(userAddDto.getUserStatus());
        return userServiceImpl.userUpdate(user);
    }

    /**
     * 用户id和用户名 Vo
     *
     * @param user
     * @return
     */
    @GetMapping("/user/listDto")
    @ApiOperation(value="用户id和用户名Vo", notes = "创建人- 小道仙")
    public AjaxResult<List<UserVo>> userDtoList(){
        return userServiceImpl.userDtoList();
    }


    /**
     *  @HystrixCommand
     *  这是 hystrix的一个服务容错处理，当然该方法异常的时候，就去调用 processHystrix_Get 方法
     */
    @GetMapping("/user/getById/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @ApiOperation(value = "测试接口", hidden = true)
    public User getById(@PathVariable("id")  String id){
        System.out.println("id = " + id);
        User user = userServiceImpl.getById(id);
        if (user == null){
            throw new  RuntimeException("测试异常！");
        }
        return user;
    }

    public User processHystrix_Get(@PathVariable("id") String id) {
        System.out.println("进入异常了~~~~");
        User user = new User().setUserName("报错了，出异常了!!!");
        return user;
    }
}