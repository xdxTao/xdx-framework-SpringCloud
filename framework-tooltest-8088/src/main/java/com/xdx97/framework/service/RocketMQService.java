package com.xdx97.framework.service;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.vo.MessageVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * RocketMQ测试
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
public interface RocketMQService {

    AjaxResult<?> send(MessageVo MessageVo);


}
