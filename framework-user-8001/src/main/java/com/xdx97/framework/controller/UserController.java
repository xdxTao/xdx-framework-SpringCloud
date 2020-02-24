package com.xdx97.framework.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    public User processHystrix_Get(@PathVariable("id") String id) {
        System.out.println("进入异常了~~~~");
        User user = new User().setUserName("报错了，出异常了!!!");
        return user;
    }
}