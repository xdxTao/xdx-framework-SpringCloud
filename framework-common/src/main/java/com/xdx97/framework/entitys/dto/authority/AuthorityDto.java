package com.xdx97.framework.entitys.dto.authority;

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
public class AuthorityDto {
    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 菜单名称
     */
    private List<String> menuNames;
}