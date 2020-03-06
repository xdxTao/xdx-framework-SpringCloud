package com.xdx97.framework.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.dto.user.UserDto;
import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.service.impl.UserServiceImpl;
import com.xdx97.framework.utils.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户相关的操作
 *
 * @author 小道仙
 * @date 2020年2月27日
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @GetMapping("/user/list")
    public AjaxResult<List<User>> list(){

        return userServiceImpl.selectList();
    }

    /**
     *  @HystrixCommand
     *  这是 hystrix的一个服务容错处理，当然该方法异常的时候，就去调用 processHystrix_Get 方法
     */
    @GetMapping("/user/getById/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public User getById(@PathVariable("id")  String id){
        System.out.println("id = " + id);
        User user = userServiceImpl.getById(id);
        if (user == null){
            throw new  RuntimeException("测试异常！");
        }
        return user;
    }

    @GetMapping("/user/login")
    public AjaxResult<?> login(@RequestParam String userName, @RequestParam String userPassword){
        User user = new User();
        user.setUserName(userName).setUserPassword(userPassword);
        return userServiceImpl.login(user);
    }

    @PostMapping("/user/save")
    public AjaxResult<?> userSave(@RequestBody User user){

        return userServiceImpl.userSave(user);
    }

    @PostMapping("/user/update")
    public AjaxResult<?> userUpdate(@RequestBody User user){

        return userServiceImpl.userUpdate(user);
    }

    /**
     * @param user
     * @return
     */
    @GetMapping("/user/listDto")
    public AjaxResult<List<UserDto>> userDtoList(){

        return userServiceImpl.userDtoList();
    }


    public User processHystrix_Get(@PathVariable("id") String id) {
        System.out.println("进入异常了~~~~");
        User user = new User().setUserName("报错了，出异常了!!!");
        return user;
    }
}