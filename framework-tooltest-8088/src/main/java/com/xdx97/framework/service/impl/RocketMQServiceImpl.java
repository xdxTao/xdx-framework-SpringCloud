package com.xdx97.framework.service.impl;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.common.MyCommonService;
import com.xdx97.framework.entitys.dto.other.MessageDto;
import com.xdx97.framework.service.RocketMQService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RocketMQServiceImpl extends MyCommonService implements RocketMQService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public AjaxResult<?> send(MessageDto MessageVo) {

        Map<String,Object> header = new HashMap<>();
        header.put("userIds",MessageVo.getUserIds());
        header.put("sendUserId",getCurUser().getUserId());
        rocketMQTemplate.convertAndSend("user-topic", MessageVo.getMessage(),header);
        return AjaxResult.success("发送成功!");
    }

}
