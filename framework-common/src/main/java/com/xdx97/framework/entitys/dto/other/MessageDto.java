package com.xdx97.framework.entitys.dto.other;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


/**
 * 前台MQ测试消息接收
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
@Data
@Accessors(chain = true)
@ApiModel("MQ测试消息接收")
public class MessageDto {

    @ApiModelProperty("测试消息")
    private String message;

    @ApiModelProperty("发送用户")
    private List<String> userIds;
}