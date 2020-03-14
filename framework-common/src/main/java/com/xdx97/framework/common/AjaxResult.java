package com.xdx97.framework.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 封装返回结果集
 *
 * @author 小道仙
 * @date 2020年2月17日
 */
@Data
@Accessors(chain = true)
@ApiModel("返回结果集")
public class AjaxResult<T> {
    /**
     * 返回状态码
     */
    @ApiModelProperty("状态码")
    private Integer code;

    /**
     * 返回的数据
     */
    @ApiModelProperty("返回的数据")
    private T data;

    /**
     * 总条数
     */
    @ApiModelProperty("总条数")
    private Long total;

    /**
     * 成功与否
     */
    @ApiModelProperty("成功与否")
    private Boolean success;

    /**
     * 消息提示
     */
    @ApiModelProperty("消息提示")
    private String msg;

    /**
     * 错误描述
     */
    @ApiModelProperty("错误描述")
    private String errDesc;

    /**
     * 用户token
     */
    @ApiModelProperty("用户token")
    private String xdxToken;

    public AjaxResult() {
    }

    /**
     * 操作失败
     * @param errDesc 错误信息
     *
     * @author 小道仙
     * @date 2020年2月17日
     */
    public static AjaxResult<?> failure(String errDesc) {
        return new AjaxResult<>().setErrDesc(errDesc).setSuccess(false);
    }

    /**
     * 操作成功
     * @param msg  返回消息
     * @param total 总条数
     * @param data 返回的数据
     *
     * @author 小道仙
     * @date 2020年2月17日
     */
    public static <T> AjaxResult<T> success(String msg,long total,T data){
        AjaxResult<T> result = new AjaxResult<>();
        result.setSuccess(true)
                .setTotal(total)
                .setMsg(msg);
        return result;
    }

    /**
     * 操作成功
     * @param total 总条数
     * @param data 返回的数据
     *
     * @author 小道仙
     * @date 2020年2月17日
     */
    public static <T> AjaxResult<T> success(T data,long total){
        AjaxResult<T> result = new AjaxResult<>();
        result.setSuccess(true)
                .setTotal(total)
                .setMsg("操作成功")
                .setData(data);
        return result;
    }

    /**
     * 操作成功
     * @param data 返回的数据
     *
     * @author 小道仙
     * @date 2020年2月22日
     */
    public static <T> AjaxResult<T> success(T data){
        AjaxResult<T> result = new AjaxResult<>();
        result.setSuccess(true)
                .setMsg("操作成功")
                .setData(data);
        return result;
    }

    /**
     * 操作成功
     * @param msg  返回消息
     *
     * @author 小道仙
     * @date 2020年2月17日
     */
    public static <T> AjaxResult<T> success(String msg){
        return success(msg,0,null);
    }

    /**
     * 操作成功
     * @param msg  返回消息
     * @param total 总条数
     *
     * @author 小道仙
     * @date 2020年2月17日
     */
    public static <T> AjaxResult<T> success(String msg,Integer total){
        return success(msg,total,null);
    }

    /**
     * 操作成功
     *
     * @author 小道仙
     * @date 2020年2月17日
     */
    public static <T> AjaxResult<T> success(){
        return success("操作成功",0,null);
    }
}