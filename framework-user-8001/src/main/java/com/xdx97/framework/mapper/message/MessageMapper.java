package com.xdx97.framework.mapper.message;

import com.xdx97.framework.common.MyBaseMapper;
import com.xdx97.framework.entitys.pojo.rocketmq.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper extends MyBaseMapper<Message> {
    /**
     * 通过用户ID获取消息条数
     *
     * @param userId 用户id
     * @return
     * @author 小道仙
     * @date 2020年3月6日
     */
    Integer getUnreadCountById(@Param("userId") String userId);

    /**
     * 通过用户ID获取总消息数
     *
     * @param userId 用户id
     * @return
     * @author 小道仙
     * @date 2020年3月6日
     */
    List<Message> list(@Param("userId") String userId);
}
