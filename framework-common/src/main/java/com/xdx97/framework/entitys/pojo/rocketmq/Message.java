package com.xdx97.framework.entitys.pojo.rocketmq;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xdx97.framework.enums.YesOrNoStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息实体
 *
 * @author 小道仙
 * @date 2020年3月6日
 */
@Data
@Accessors(chain = true)
@ApiModel("消息实体")
public class Message {
    /**
     * 消息id
     */
    @TableId
    @ApiModelProperty("消息ID")
    private String msgId;

    /**
     * 消息内容
     */
    @ApiModelProperty("消息内容")
    private String msgContent;

    /**
     * 接收者id
     */
    @ApiModelProperty("接收者id")
    private String recvId;

    /**
     * 发送者id
     */
    @ApiModelProperty("发送者id")
    private String senderId;

    /**
     * 消息类别(目前就默认0,就一种)
     */
    private Integer msgType;

    /**
     * 消息状态(0 未读，1 已读)
     */
    @ApiModelProperty("消息状态(0 未读，1 已读)")
    private YesOrNoStatusEnum msgSts;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date gmtModified;

    /** 发送者name */
    @TableField(exist = false)
    @ApiModelProperty("发送者昵称")
    private String senderName;
}