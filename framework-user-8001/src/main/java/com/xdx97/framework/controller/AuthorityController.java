package com.xdx97.framework.controller;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.dto.authority.AuthorityDto;
import com.xdx97.framework.entitys.dto.authority.AuthorityResult;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import com.xdx97.framework.entitys.pojo.authority.Role;
import com.xdx97.framework.service.impl.AuthorityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限相关
 *
 * @author 小道仙
 * @date 2020年2月19日
 */
@RestController
public class AuthorityController {

    @Autowired
    private AuthorityServiceImpl authorityService;

    /******************************  菜单  ******************************/

    /**
     * 添加菜单
     *
     * @param menu
     * @return
     * @author 小道仙
     * @date 2020年2月19日
     */
    @PostMapping("/authority/menu/add")
    public AjaxResult<?> addMenu(@RequestBody Menu menu){
        return authorityService.addMenu(menu);
    }

    /**
     * 菜单管理列表
     *
     * @param flag 查询的类型
     */
    @GetMapping("/authority/menuMgmt/list")
    public AjaxResult<List<Menu>> meanMgmtList(){
        return authorityService.meanMgmtList();
    }

    /**
     * 菜单列表
     *
     * @param flag 查询的类型
     */
    @GetMapping("/authority/menu/list")
    public AjaxResult<List<Menu>> menuList(){
        return authorityService.menuList();
    }

    /**
     * 更新菜单
     *
     */
    @PostMapping("/authority/menu/update")
    public AjaxResult<?> meanUpdate(@RequestBody Menu menu){

        return authorityService.meanUpdate(menu);
    }

    /******************************  角色  ******************************/

    /**
     * 添加角色
     *
     */
    @PostMapping("/authority/role/add")
    public AjaxResult<?> roleAdd(@RequestBody Role role){

        return authorityService.roleAdd(role);
    }

    /**
     * 角色列表
     *
     */
    @GetMapping("/authority/role/list")
    public AjaxResult<List<Role>> roleList(){

        return authorityService.roleList();
    }

    /**
     * 角色更新
     *
     */
    @PostMapping("/authority/role/update")
    public AjaxResult<?> roleUpdate(@RequestBody Role role){

        return authorityService.roleUpdate(role);
    }

    /******************************  权限  ******************************/

    /**
     * 权限列表
     *
     * @return
     */
    @GetMapping("/authority/list")
    public AjaxResult<List<AuthorityDto>> authorityList(){

        return authorityService.authorityList();
    }

    /**
     * 权限保存
     *
     * @return
     */
    @PostMapping("/authority/save")
    public AjaxResult<?> authoritySave(@RequestBody AuthorityResult authorityResult){

        return authorityService.authoritySave(authorityResult);
    }

    /**
     * 获取当前角色的权限
     *
     * @return
     */
    @GetMapping("/authority/listByRoleId")
    public AjaxResult<List<String>> listByRoleId(@RequestParam String roleId){

        return authorityService.listByRoleId(roleId);
    }
}
