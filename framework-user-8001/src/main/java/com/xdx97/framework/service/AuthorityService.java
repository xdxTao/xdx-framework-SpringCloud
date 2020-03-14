package com.xdx97.framework.service;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.vo.authority.AuthorityVo;
import com.xdx97.framework.entitys.vo.authority.AuthorityResult;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import com.xdx97.framework.entitys.pojo.authority.Role;

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
     * @return
     */
    AjaxResult<List<Menu>> menuList();

    /**
     * 菜单管理列表
     *
     * @return
     */
    AjaxResult<List<Menu>> meanMgmtList();

    /**
     * 更新菜单
     *
     * @param menu
     * @return
     */
    AjaxResult<?> meanUpdate(Menu menu);




    /******************************  角色  ******************************/
    /**
     * 添加角色
     *
     * @param Role
     * @return
     */
    AjaxResult<?> roleAdd(Role role);

    /**
     * 角色列表
     *
     * @param Role
     * @return
     */
    AjaxResult<List<Role>> roleList();

    /**
     * 角色更新
     *
     * @param Role
     * @return
     */
    AjaxResult<?> roleUpdate(Role role);


    /******************************  权限  ******************************/

    /**
     * 权限列表
     *
     * @return
     */
    AjaxResult<List<AuthorityVo>> authorityList();

    /**
     * 权限保存
     *
     * @return
     */
    AjaxResult<?> authoritySave(AuthorityResult authorityResult);

    /**
     * 获取当前角色的权限
     *
     * @return
     */
    AjaxResult<List<String>> listByRoleId(String roleId);

}
