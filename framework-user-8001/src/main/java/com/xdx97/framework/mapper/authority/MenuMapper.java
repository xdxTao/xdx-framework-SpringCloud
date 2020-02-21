package com.xdx97.framework.mapper.authority;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 获取一级菜单
     *
     * flag = 1 表示菜单栏
     * flag = 2 表示实际菜单
     * @return
     */
    List<Menu> getOneMenu(@Param("flag") Integer flag);
}
