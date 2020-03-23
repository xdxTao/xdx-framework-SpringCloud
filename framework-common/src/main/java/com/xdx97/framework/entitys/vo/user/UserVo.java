package com.xdx97.framework.entitys.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserVo
 *
 * @author 小道仙
 * @date 2020年3月5日
 */
@Data
@Accessors(chain = true)
@ApiModel("用户名和用户idVo")
public class UserVo {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户状态")
    private Boolean disabled;
}
