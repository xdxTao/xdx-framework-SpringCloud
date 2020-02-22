package com.xdx97.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.dto.authority.AuthorityDto;
import com.xdx97.framework.entitys.dto.authority.AuthorityResult;
import com.xdx97.framework.entitys.pojo.authority.Authority;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import com.xdx97.framework.entitys.pojo.authority.Role;
import com.xdx97.framework.enums.YesOrNoStatusEnum;
import com.xdx97.framework.mapper.authority.AuthorityMapper;
import com.xdx97.framework.mapper.authority.MenuMapper;
import com.xdx97.framework.mapper.authority.RoleMapper;
import com.xdx97.framework.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdx97.framework.utils.primarykeysnowflake.PrimaryKeySnowflakeGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;


    /******************************  菜单  ******************************/

    @Override
    public AjaxResult<?> addMenu(Menu menu) {

        menu.setUserCreate("1")
                .setGmtCreate(new Date())
                .setMenuSts(YesOrNoStatusEnum.YES)
                .setMenuId(menu.getMenuAddr());
        menuMapper.insert(menu);
        return AjaxResult.success("添加成功");
    }

    @Override
    public AjaxResult<List<Menu>> meanList(Integer flag) {
        List<Menu> menus = menuMapper.getOneMenu(flag);
        if (flag == 1){
            for (Menu item : menus){
                QueryWrapper<Menu> qw = new QueryWrapper();
                qw.orderByAsc("menu_sort");
                qw.setEntity(new Menu().setSupMenuId(item.getMenuId()));
                List<Menu> lists = menuMapper.selectList(qw);
                lists.forEach(iten -> {
                    iten.setMenuStsBoolean(iten.getMenuSts() == YesOrNoStatusEnum.YES ? true : false);
                });
                item.setLists(lists)
                        .setMenuStsBoolean(item.getMenuSts() == YesOrNoStatusEnum.YES ? true : false);

            }
        }else{
            for (Menu item : menus){
                QueryWrapper<Menu> qw = new QueryWrapper();
                qw.orderByAsc("menu_sort");
                qw.setEntity(new Menu().setSupMenuId(item.getMenuId()).setMenuSts(YesOrNoStatusEnum.YES));
                item.setLists(menuMapper.selectList(qw));
            }
        }
        return AjaxResult.success(menus);
    }

    @Override
    public AjaxResult<?> meanUpdate(Menu menu) {
        menuMapper.updateById(menu);
        return AjaxResult.success("更新成功");
    }



    /******************************  角色  ******************************/
    @Override
    public AjaxResult<?> roleAdd(Role role) {
        QueryWrapper<Role> qw = new QueryWrapper();
        qw.setEntity(new Role().setRoleName(role.getRoleName()));
        List<Role> roles = roleMapper.selectList(qw);
        if (roles != null && roles.size() > 0){
            return AjaxResult.failure("该角色已存在");
        }
        PrimaryKeySnowflakeGenerator primaryKeySnowflake = new PrimaryKeySnowflakeGenerator();
        role.setGmtCreate(new Date())
                .setUserCreate("1")
                .setRoleId(primaryKeySnowflake.generate(role));
        roleMapper.insert(role);
        return AjaxResult.success("新增成功");
    }

    @Override
    public AjaxResult<List<Role>> roleList() {
        List<Role> roles = roleMapper.selectList(null);
        return AjaxResult.success(roles);
    }

    @Override
    public AjaxResult<?> roleUpdate(Role role) {
        role.setGmtModified(new Date())
                .setUserModified("1");
        roleMapper.updateById(role);
        return AjaxResult.success("更新成功!");
    }


    /******************************  权限  ******************************/

    @Override
    public AjaxResult<List<AuthorityDto>> authorityList() {
        List<AuthorityDto> lists = new ArrayList<>();
        List<Menu> menus = menuMapper.getOneMenu(1);
        menus.remove(0);
        for (Menu item : menus){
            AuthorityDto dto = new AuthorityDto();
            dto.setGroupName(item.getMenuName())
                    .setMenuNames(menuMapper.getByIdName(item.getMenuId()));
            lists.add(dto);
        }
        return AjaxResult.success(lists);
    }

    @Override
    public AjaxResult<?> authoritySave(AuthorityResult authorityResult) {
        String roleId = authorityResult.getRoleId();
        QueryWrapper<Authority> q = new QueryWrapper();
        q.setEntity(new Authority().setRoleId(roleId));
        authorityMapper.delete(q);
        for (String menuName : authorityResult.getSelectList()){
            QueryWrapper<Menu> qw = new QueryWrapper();
            qw.setEntity(new Menu().setMenuName(menuName));
            Menu menu = menuMapper.selectOne(qw);
            authorityMapper.insert(new Authority().setRoleId(roleId).setMenuId(menu.getMenuId()));
        }
        return AjaxResult.success("保存成功!");
    }

    @Override
    public AjaxResult<List<String>> listbyroleId(String roleId) {
        List<String> lists = authorityMapper.listbyroleId(roleId);
        if (lists == null || lists.size() <= 0){
            return AjaxResult.success(new ArrayList<String>());
        }
        List<String> result = menuMapper.selectNameById(lists);
        return AjaxResult.success(result);
    }
}
