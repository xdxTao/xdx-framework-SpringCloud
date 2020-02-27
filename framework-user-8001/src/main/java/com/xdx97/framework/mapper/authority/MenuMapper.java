package com.xdx97.framework.mapper.authority;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xdx97.framework.common.MyBaseMapper;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface MenuMapper extends MyBaseMapper<Menu> {

    /**
     * 获取一级菜单
     *
     * @param flag
     * @return
     */
    List<Menu> getOneMenu();

    /**
     * 获取全部的权限菜单
     *
     * @param supMenuId
     * @return
     */
    List<String> getByIdName(@Param("supMenuId") String supMenuId);

    /**
     * 根据ID获取菜单名称
     *
     * @param lists
     * @return
     */
    List<String> selectNameById(List<String> lists);

    /**
     * 把已知菜单进行排序
     *
     * @param oneMenu
     * @return
     */
    List<Menu> getSortMenu(@Param("set") Set<String> oneMenu);
}
