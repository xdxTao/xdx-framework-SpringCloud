package com.xdx97.framework.controller;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.rocketmq.Message;
import com.xdx97.framework.service.impl.MessageServiceImpl;
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
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    /**
     * 未读消息条数
     *
     * @author 小道仙
     * @date 2020年3月6日
     */
    @GetMapping("/message/unreadCount")
    public AjaxResult<Integer> getUnreadCount(){
       return messageService.getUnreadCount();
    }

    /**
     * 消息列表
     *
     * @return
     */
    @GetMapping("/message/list")
    public AjaxResult<List<Message>> list(){
        return messageService.list();
    }

    /**
     * 消息已读操作
     *
     * @return
     */
    @GetMapping("/message/alreadyRead")
    public AjaxResult<?> alreadyRead(@RequestParam String msgId){
        return messageService.alreadyRead(msgId);
    }

}
