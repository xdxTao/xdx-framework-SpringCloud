package com.xdx97.framework.entitys.dto.user;

import com.xdx97.framework.enums.YesOrNoStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户新增/更新dto
 *
 * @author 小道仙
 * @date 2020年3月14日
 */
@Data
@Accessors(chain = true)
@ApiModel("用户新增更新dto")
public class UserAddDto implements Serializable {

    /**
     * 用户id
     */
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
     * 用户状态:1启用0停用
     */
    @ApiModelProperty("用户状态")
    private YesOrNoStatusEnum userStatus;

    /**
     * 头像路径
     */
    @ApiModelProperty("头像路径")
    private String headImgPath;

    private static final long serialVersionUID = 1L;
}
