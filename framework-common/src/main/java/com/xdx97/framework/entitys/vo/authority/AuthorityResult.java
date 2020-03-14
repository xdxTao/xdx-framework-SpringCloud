package com.xdx97.framework.entitys.vo.authority;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
/**
 * 权限保存Dto
 *
 * @author 小道仙
 * @date 2020年2月22日
 */
@Data
@Accessors(chain = true)
@ApiModel("权限保存Dto")
public class AuthorityResult {

    /**
     * 角色Id
     */
    @ApiModelProperty("角色Id")
    private String roleId;

    /**
     * 选中的权限菜单
     */
    @ApiModelProperty("选中的权限菜单")
    private List<String> selectList;
}
