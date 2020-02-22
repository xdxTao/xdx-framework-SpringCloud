package com.xdx97.framework.mapper.authority;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xdx97.framework.entitys.pojo.authority.Authority;
import com.xdx97.framework.entitys.pojo.authority.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorityMapper extends BaseMapper<Authority> {

    /**
     * 根据 角色ID 获取权限名
     *
     * @param roleId
     * @return
     */
    List<String> listbyroleId(@Param("roleId") String roleId);
}
