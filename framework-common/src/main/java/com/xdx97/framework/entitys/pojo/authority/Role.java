package com.xdx97.framework.entitys.pojo.authority;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体
 *
 * @author 小道仙
 * @date 2020年2月19日
 */
@Data
@Accessors(chain = true)
@ApiModel("角色实体")
public class Role {
    /**
     * 角色id
     */
    @TableId
    @ApiModelProperty("角色id")
    private String roleId;

    /**
     * 角色名
     */
    @ApiModelProperty("角色名")
    private String roleName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date gmtModified;

    /**
     * 创建人
     */
    private String userCreate;

    /**
     * 修改人
     */
    private String userModified;
}