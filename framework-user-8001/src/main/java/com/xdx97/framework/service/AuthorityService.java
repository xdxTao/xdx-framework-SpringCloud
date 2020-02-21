package com.xdx97.framework.service;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AuthorityService {
    /******************************  菜单  ******************************/

    /**
     * 添加菜单
     *
     * @param menu
     * @return
     */
    AjaxResult<?> addMenu(Menu menu);

    /**
     * 菜单列表
     *
     * @param flag 查询的类型
     * @return
     */
    AjaxResult<List<Menu>> meanList(Integer flag);

    /**
     * 更新菜单
     *
     * @param menu
     * @return
     */
    AjaxResult<?> meanUpdate(Menu menu);


    /******************************  角色  ******************************/



    /******************************  权限  ******************************/
}
