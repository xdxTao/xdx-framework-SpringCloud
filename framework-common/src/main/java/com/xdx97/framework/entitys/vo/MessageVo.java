package com.xdx97.framework.entitys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


/**
 * 前台MQ测试消息接受
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
@Data
@Accessors(chain = true)
public class MessageVo {

    private String message;

    private List<String> userIds;
}