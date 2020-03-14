package com.xdx97.framework.controller;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.rocketmq.Message;
import com.xdx97.framework.service.impl.MessageServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
@RestController
@Api(tags = "消息接口", description = "提供消息相关的 Rest API")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    /**
     * 未读消息条数
     *
     * @author 小道仙
     * @date 2020年3月6日
     */
    @ApiOperation(value = "未读消息条数", notes = "创建人 - 小道仙")
    @GetMapping("/message/unreadCount")
    public AjaxResult<Integer> getUnreadCount(){
       return messageService.getUnreadCount();
    }

    /**
     * 消息列表
     *
     * @return
     */
    @ApiOperation(value = "消息列表", notes = "创建人 - 小道仙")
    @GetMapping("/message/list")
    public AjaxResult<List<Message>> list(){
        return messageService.list();
    }

    /**
     * 消息已读操作
     *
     * @return
     */
    @ApiOperation(value = "消息已读操作", notes = "创建人 - 小道仙")
    @GetMapping("/message/alreadyRead")
    public AjaxResult<?> alreadyRead(
           @ApiParam(value = "消息id", required = true) @RequestParam String msgId){
        return messageService.alreadyRead(msgId);
    }

}
