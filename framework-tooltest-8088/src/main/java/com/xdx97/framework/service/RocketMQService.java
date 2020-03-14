package com.xdx97.framework.service;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.dto.other.MessageDto;

/**
 * RocketMQ测试
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
public interface RocketMQService {

    AjaxResult<?> send(MessageDto MessageVo);


}
