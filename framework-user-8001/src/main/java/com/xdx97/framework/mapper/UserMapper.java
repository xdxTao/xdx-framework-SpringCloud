package com.xdx97.framework.mapper;

import com.xdx97.framework.common.MyBaseMapper;
import com.xdx97.framework.entitys.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 继承这个BaseMapper是MybatisPlus的功能
 */
@Mapper
public interface UserMapper extends MyBaseMapper<User> {

}
