package com.xdx97.framework.entitys.dto.authority;

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
public class AuthorityResult {

    /**
     * j角色Id
     */
    private String roleId;

    /**
     * 选中的权限菜单
     */
    private List<String> selectList;
}
