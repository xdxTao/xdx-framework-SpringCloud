package com.xdx97.framework.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 对默认的方法进行一定的覆盖
 * @author 小道仙
 * @date 2020年2月26日
 */
public interface MyBaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T>  {

    /**
     * 查询列表
     * @param t
     * @return java.util.List<T>
     * @author 小道仙
     * @date 2020年2月26日
     * @version 1.0
     */
    default List<T> selectList(T t) {
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.setEntity(t);
        return selectList(qw);
    }

    /**
     * 查询一条记录
     * @param t
     * @return
     * @author 小道仙
     * @date 2020年2月26日
     * @version 1.0
     */
    default T selectOne(T t){
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.setEntity(t);
        return selectOne(qw);
    }
}
