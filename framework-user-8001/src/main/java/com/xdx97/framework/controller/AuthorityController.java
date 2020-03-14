package com.xdx97.framework.controller;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.dto.authority.MenuAddDto;
import com.xdx97.framework.entitys.dto.authority.RoleAddDto;
import com.xdx97.framework.entitys.vo.authority.AuthorityVo;
import com.xdx97.framework.entitys.vo.authority.AuthorityResult;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import com.xdx97.framework.entitys.pojo.authority.Role;
import com.xdx97.framework.service.impl.AuthorityServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "权限相关", description = "菜单 - 角色 - 权限,相关的Rest API")
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
    @ApiOperation(value="添加菜单", notes = "创建人 - 小道仙")
    @PostMapping("/authority/menu/add")
    public AjaxResult<?> addMenu(@RequestBody MenuAddDto menuAddDto){
        Menu menu = new Menu();
        menu.setSupMenuId(menuAddDto.getSupMenuId())
                .setMenuName(menuAddDto.getMenuName())
                .setMenuAddr(menuAddDto.getMenuAddr())
                .setMenuImg(menuAddDto.getMenuImg());
        return authorityService.addMenu(menu);
    }

    /**
     * 菜单管理列表
     *
     * @author 小道仙
     * @date 2020年3月14日
     */
    @GetMapping("/authority/menuMgmt/list")
    @ApiOperation(value = "菜单管理列表", notes = "创建人 - 小道仙")
    public AjaxResult<List<Menu>> meanMgmtList(){
        return authorityService.meanMgmtList();
    }

    /**
     * 菜单列表
     *
     * @author 小道仙
     * @date 2020年3月14日
     */
    @GetMapping("/authority/menu/list")
    @ApiOperation(value = "菜单列表", notes = "创建人 - 小道仙")
    public AjaxResult<List<Menu>> menuList(){
        return authorityService.menuList();
    }

    /**
     * 更新菜单
     *
     * @author 小道仙
     * @date 2020年3月14日
     */
    @PostMapping("/authority/menu/update")
    @ApiOperation(value = "更新菜单", notes = "创建人 - 小道仙")
    public AjaxResult<?> meanUpdate(@RequestBody MenuAddDto menuAddDto){

        Menu menu = new Menu();
        menu.setSupMenuId(menuAddDto.getSupMenuId())
                .setMenuName(menuAddDto.getMenuName())
                .setMenuAddr(menuAddDto.getMenuAddr())
                .setMenuImg(menuAddDto.getMenuImg())
                .setMenuSort(menuAddDto.getMenuSort())
                .setMenuSts(menuAddDto.getMenuSts());
        return authorityService.meanUpdate(menu);
    }

    /******************************  角色  ******************************/

    /**
     * 添加角色
     *
     * @author 小道仙
     * @date 2020年3月14日
     */
    @ApiOperation(value = "添加角色", notes = "创建人 - 小道仙")
    @PostMapping("/authority/role/add")
    public AjaxResult<?> roleAdd(@RequestBody RoleAddDto roleAddDto){
        Role role = new Role();
        role.setRoleName(roleAddDto.getRoleName());
        return authorityService.roleAdd(role);
    }

    /**
     * 角色列表
     *
     * @author 小道仙
     * @date 2020年3月14日
     */
    @GetMapping("/authority/role/list")
    @ApiOperation(value = "角色列表", notes = "创建人 - 小道仙")
    public AjaxResult<List<Role>> roleList(){

        return authorityService.roleList();
    }

    /**
     * 角色更新
     *
     * @author 小道仙
     * @date 2020年3月14日
     */
    @PostMapping("/authority/role/update")
    @ApiOperation(value = "角色更新", notes = "创建人 - 小道仙")
    public AjaxResult<?> roleUpdate(@RequestBody RoleAddDto roleAddDto){
        Role role = new Role();
        role.setRoleName(roleAddDto.getRoleName())
                .setRoleId(roleAddDto.getRoleId());
        return authorityService.roleUpdate(role);
    }

    /******************************  权限  ******************************/

    /**
     * 权限列表
     *
     * @author 小道仙
     * @date 2020年3月14日
     */
    @GetMapping("/authority/list")
    @ApiOperation(value = "权限列表", notes = "创建人 - 小道仙")
    public AjaxResult<List<AuthorityVo>> authorityList(){

        return authorityService.authorityList();
    }

    /**
     * 权限保存
     *
     * @author 小道仙
     * @date 2020年3月14日
     */
    @ApiOperation(value = "权限保存", notes = "创建人 - 小道仙")
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
    @ApiOperation(value = "获取当前角色的权限", notes = "创建人 - 小道仙")
    public AjaxResult<List<String>> listByRoleId(
            @ApiParam(value = "角色id", required = true) @RequestParam String roleId){

        return authorityService.listByRoleId(roleId);
    }
}
