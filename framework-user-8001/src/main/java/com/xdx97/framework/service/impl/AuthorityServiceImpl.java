package com.xdx97.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.common.MyCommonService;
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
import com.xdx97.framework.utils.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdx97.framework.utils.primarykeysnowflake.PrimaryKeySnowflakeGenerator;

import java.util.*;

@Service
public class AuthorityServiceImpl extends MyCommonService
        implements AuthorityService {

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
    public AjaxResult<List<Menu>> menuList() {
        String roleId = getCurUser().getRoleId();
        List<Authority> authorities = authorityMapper.selectList(new Authority().setRoleId(roleId));
        Set<String> oneMenu = new HashSet<>();
        Map<String,HashSet<String>> towMenu = new HashMap<>();
        for (Authority item : authorities){
            String one = getOneOrTwoMenu(item.getMenuId());
            oneMenu.add(one);
            if (!item.getMenuId().equals(one)){
                HashSet<String> set = towMenu.get(one);
                if (set == null){
                    set = new HashSet<>();
                }
                set.add(item.getMenuId());
                towMenu.put(one,set);
            }
        }
        List<Menu> menus = new ArrayList<>();
        // 排序好的一级菜单
        List<Menu> oneSortMent = menuMapper.getSortMenu(oneMenu);
        for (Menu menu : oneSortMent){
            HashSet<String> sets = towMenu.get(menu.getMenuAddr());
            if (sets == null || sets.size() <= 0){
                menu.setLists(new ArrayList<>());
            }else {
                menu.setLists(menuMapper.getSortMenu(towMenu.get(menu.getMenuAddr())));
            }
            menus.add(menu);
        }
        return AjaxResult.success(menus);
    }

    @Override
    public AjaxResult<List<Menu>> meanMgmtList() {
        List<Menu> menus = menuMapper.getOneMenu();
        // 用户管理下的菜单列表
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
        List<Role> roles = roleMapper.selectList(new Role());
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
        List<Menu> menus = menuMapper.getOneMenu();
        for (Menu item : menus){
            AuthorityDto dto = new AuthorityDto().setGroupName(item.getMenuName());
            List<String> listMenu = menuMapper.getByIdName(item.getMenuId());
            // 没有子菜单
            if (listMenu == null || listMenu.size() <= 0){
                listMenu.add(item.getMenuName());

            }
            dto.setMenuNames(listMenu);
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
            Menu menu = menuMapper.selectOne(new Menu().setMenuName(menuName));
            authorityMapper.insert(new Authority().setRoleId(roleId).setMenuId(menu.getMenuId()));
        }
        // 把当前角色的权限保存到Redis里面去
        List<String> meuns =  authorityMapper.listByRoleId(roleId);
        RedisUtils.set(roleId,meuns,60*24*30);
        return AjaxResult.success("保存成功!");
    }

    @Override
    public AjaxResult<List<String>> listByRoleId(String roleId) {
        List<String> lists = authorityMapper.listByRoleId(roleId);
        if (lists == null || lists.size() <= 0){
            return AjaxResult.success(new ArrayList<String>());
        }
        List<String> result = menuMapper.selectNameById(lists);
        return AjaxResult.success(result);
    }

    /**
     * 返回一级菜单
     * @param url
     * @return 返回一级菜单或者返回false
     */
    private String getOneOrTwoMenu(String url){
        StringBuilder result = new StringBuilder();
        char[] chars = url.toCharArray();
        int count = 0;
        for (char item : chars){
            if (item == '/'){
                count ++;
            }
            if (count >= 2){
                return result.toString();
            }
            result.append(item);
        }
        return url;
    }
}
