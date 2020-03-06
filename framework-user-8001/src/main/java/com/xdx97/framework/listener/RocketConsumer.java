package com.xdx97.framework.listener;

import com.xdx97.framework.entitys.pojo.rocketmq.Message;
import com.xdx97.framework.enums.YesOrNoStatusEnum;
import com.xdx97.framework.mapper.message.MessageMapper;
import com.xdx97.framework.service.impl.MessageServiceImpl;
import com.xdx97.framework.utils.primarykeysnowflake.PrimaryKeySnowflakeGenerator;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户消息消费者
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
@Service
@RocketMQMessageListener(consumerGroup = "my-consumer_user-topic", topic = "user-topic")
public class RocketConsumer implements RocketMQListener<MessageExt> {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void onMessage(MessageExt messageExt) {
        PrimaryKeySnowflakeGenerator primaryKeySnowflake = new PrimaryKeySnowflakeGenerator();
        System.out.println("消息来了 ...........");
        String userIds = messageExt.getProperty("userIds");
        String sendUserId = messageExt.getProperty("sendUserId");
        String[] ids = userIds.substring(1, userIds.length() - 1).replaceAll(" ","").split(",");
        String msg = new String(messageExt.getBody());
        for (String id : ids){
            Message message = new Message();
            message.setMsgType(0)
                    .setGmtCreate(new Date())
                    .setMsgContent(msg)
                    .setMsgSts(YesOrNoStatusEnum.NO)
                    .setRecvId(id)
                    .setSenderId(sendUserId);
            message.setMsgId(primaryKeySnowflake.generate(message));
            messageMapper.insert(message);
        }
        System.out.println("消息接受完毕 ...........");
    }
}
