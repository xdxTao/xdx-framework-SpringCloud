package com.xdx97.framework.service.impl;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.common.MyCommonService;
import com.xdx97.framework.entitys.pojo.rocketmq.Message;
import com.xdx97.framework.enums.YesOrNoStatusEnum;
import com.xdx97.framework.mapper.message.MessageMapper;
import com.xdx97.framework.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 消息实现类
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
@Service
public class MessageServiceImpl extends MyCommonService implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public AjaxResult<Integer> getUnreadCount() {

        Integer count = messageMapper.getUnreadCountById(getCurUser().getUserId());

        return AjaxResult.success(count);
    }

    @Override
    public AjaxResult<List<Message>> list() {
        List<Message> messages = messageMapper.list(getCurUser().getUserId());
        return AjaxResult.success(messages);
    }

    @Override
    public AjaxResult<?> alreadyRead(String msgId) {
        messageMapper.updateById(new Message().setMsgId(msgId).setMsgSts(YesOrNoStatusEnum.YES).setGmtModified(new Date()));
        return AjaxResult.success("操作成功");
    }
}
