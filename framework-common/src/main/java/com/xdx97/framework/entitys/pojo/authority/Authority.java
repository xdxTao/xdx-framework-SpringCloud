package com.xdx97.framework.entitys.pojo.authority;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 权限实体
 *
 * @author 小道仙
 * @date 2020年2月19日
 */
@Data
@Accessors(chain = true)
public class Authority {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 菜单id
     */
    private String menuId;
}