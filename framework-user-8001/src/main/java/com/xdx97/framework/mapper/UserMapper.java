package com.xdx97.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xdx97.framework.entitys.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 继承这个BaseMapper是MybatisPlus的功能
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
