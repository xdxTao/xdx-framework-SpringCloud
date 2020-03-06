package com.xdx97.framework.service;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.rocketmq.Message;

import java.util.List;

/**
 * 消息接口
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
public interface MessageService {
    /**
     * 未读消息条数
     *
     * @author 小道仙
     * @date 2020年3月6日
     */
    AjaxResult<Integer> getUnreadCount();

    /**
     * 消息列表
     *
     * @return
     */
    AjaxResult<List<Message>> list();

    /**
     * 消息已读操作
     *
     * @return
     */
    AjaxResult<?> alreadyRead(String msgId);
}
