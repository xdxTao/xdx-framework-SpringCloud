package com.xdx97.framework.controller;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.vo.MessageVo;
import com.xdx97.framework.service.impl.RocketMQServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * RocketMQ
 *
 * @author 小道仙
 * @date 2020年3月5日
 */
@RestController
@Api(tags = "RocketMQ接口", description = "提供RocketMQ相关的 Rest API")
public class RocketMQController {

    @Autowired
    private RocketMQServiceImpl rocketMQService;

    @PostMapping("/tools/rocketmq")
    @ApiOperation(value="rocketmq测试" )
    public AjaxResult<?> send(@RequestBody MessageVo messageVo){
        return rocketMQService.send(messageVo);
    }
}
