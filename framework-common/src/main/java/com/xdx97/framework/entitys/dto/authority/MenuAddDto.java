package com.xdx97.framework.entitys.dto.authority;

import com.baomidou.mybatisplus.annotation.TableId;
import com.xdx97.framework.enums.YesOrNoStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 菜单新增/更新dto
 *
 * @author 小道仙
 * @date 2020年3月14日
 */
@Data
@Accessors(chain = true)
@ApiModel("菜单新增-更新实体")
public class MenuAddDto {
    /**
     * 菜单id
     */
    @TableId
    @ApiModelProperty("菜单Id")
    private String menuId;

    /**
     * 父菜单id
     */
    @ApiModelProperty("父菜单id")
    private String supMenuId;

    /**
     * 菜单名
     */
    @ApiModelProperty("菜单名")
    private String menuName;

    /**
     * 菜单地址
     */
    @ApiModelProperty("菜单地址")
    private String menuAddr;

    /**
     * 菜单状态:1启用0停用
     */
    @ApiModelProperty("菜单状态:1启用0停用")
    private YesOrNoStatusEnum menuSts;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String menuImg;

    /**
     * 菜单排序
     */
    @ApiModelProperty("菜单排序")
    private Integer menuSort;
}
