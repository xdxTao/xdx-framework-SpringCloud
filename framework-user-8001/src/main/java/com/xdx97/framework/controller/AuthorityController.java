package com.xdx97.framework.controller;

import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.authority.Menu;
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
     * 菜单列表
     *
     * @param flag 查询的类型
     */
    @GetMapping("/authority/menu/list")
    public AjaxResult<List<Menu>> meanList(@RequestParam Integer flag){
        return authorityService.meanList(flag);
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



    /******************************  权限  ******************************/
}
