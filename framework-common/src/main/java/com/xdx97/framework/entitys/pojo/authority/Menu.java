package com.xdx97.framework.entitys.pojo.authority;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xdx97.framework.enums.YesOrNoStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * 菜单实体
 *
 * @author 小道仙
 * @date 2020年2月19日
 */
@Data
@Accessors(chain = true)
public class Menu {
    /**
     * 菜单id
     */
    @TableId
    private String menuId;

    /**
     * 父菜单id
     */
    private String supMenuId;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单地址
     */
    private String menuAddr;

    /**
     * 菜单状态:1启用0停用
     */
    private YesOrNoStatusEnum menuSts;

    /**
     * 菜单图标
     */
    private String menuImg;

    /**
     * 菜单排序
     */
    private Integer menuSort;

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

    /** 子菜单*/
    @TableField(exist = false)
    private List<Menu> lists;

    /** 菜单状态 boolean */
    @TableField(exist = false)
    private Boolean menuStsBoolean;
}