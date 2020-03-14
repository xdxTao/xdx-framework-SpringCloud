package com.xdx97.framework.entitys.dto.authority;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色新增/更新Dto
 *
 * @author 小道仙
 * @date 2020年3月14日
 */
@Data
@Accessors(chain = true)
@ApiModel("角色新增-更新Dto")
public class RoleAddDto {

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private String roleId;

    /**
     * 角色名
     */
    @ApiModelProperty("角色名")
    private String roleName;
}
