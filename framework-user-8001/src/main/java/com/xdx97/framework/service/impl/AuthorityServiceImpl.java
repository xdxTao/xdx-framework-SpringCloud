package com.xdx97.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xdx97.framework.common.AjaxResult;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import com.xdx97.framework.enums.YesOrNoStatusEnum;
import com.xdx97.framework.mapper.authority.MenuMapper;
import com.xdx97.framework.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private MenuMapper menuMapper;

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
        return AjaxResult.success(menus.size(),menus);
    }

    @Override
    public AjaxResult<?> meanUpdate(Menu menu) {
        menuMapper.updateById(menu);
        return AjaxResult.success("更新成功");
    }

    /******************************  角色  ******************************/



    /******************************  权限  ******************************/
}
