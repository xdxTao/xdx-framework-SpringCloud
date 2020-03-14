package com.xdx97.framework.mapper;

import com.github.pagehelper.Page;
import com.xdx97.framework.common.MyBaseMapper;
import com.xdx97.framework.entitys.pojo.user.User;
import com.xdx97.framework.entitys.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 继承这个BaseMapper是MybatisPlus的功能
 */
@Mapper
public interface UserMapper extends MyBaseMapper<User> {

    /**
     * 用户列表
     * @param user
     * @return
     */
    Page<User> list(User user);

    /**
     * userDto 列表
     * @return
     */
    List<UserVo> userDtoList();
}
