package com.xdx97.framework.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send")
    public String send(@RequestParam String msg) {
        System.out.println("132312312");
        rocketMQTemplate.convertAndSend("test-topic",msg);
        return "success";
    }
}
