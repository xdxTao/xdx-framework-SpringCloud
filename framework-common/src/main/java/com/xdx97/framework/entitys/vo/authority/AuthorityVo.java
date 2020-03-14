package com.xdx97.framework.entitys.vo.authority;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 权限列表
 *
 * @author 小道仙
 * @date 2020年2月22日
 */
@Data
@Accessors(chain = true)
@ApiModel("权限列表Vo")
public class AuthorityVo {
    /**
     * 分组名称
     */
    @ApiModelProperty("分组名称")
    private String groupName;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private List<String> menuNames;
}