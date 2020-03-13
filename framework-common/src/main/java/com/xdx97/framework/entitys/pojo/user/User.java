package com.xdx97.framework.entitys.pojo.user;

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

@Data
@Accessors(chain = true)
@ApiModel("用户实体")
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 用户手机号
     */
    @ApiModelProperty("用户手机号")
    private String userPhone;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private String roleId;

    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String userPassword;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * openid
     */
    private String openid;

    /**
     * 用户状态:1启用0停用
     */
    @ApiModelProperty("用户状态")
    private YesOrNoStatusEnum userStatus;

    /**
     * 头像路径
     */
    @ApiModelProperty("头像路径")
    private String headImgPath;

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

    /**
     * 创建人
     */
    private String userCreate;

    /**
     * 修改人
     */
    private String userModified;

    /** 角色名 */
    @TableField(exist = false)
    @ApiModelProperty("角色名")
    private String roleName;

    private static final long serialVersionUID = 1L;
}