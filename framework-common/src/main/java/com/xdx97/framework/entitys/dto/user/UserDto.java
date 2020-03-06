package com.xdx97.framework.entitys.dto.user;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserDto
 *
 * @author 小道仙
 * @date 2020年3月5日
 */
@Data
@Accessors(chain = true)
public class UserDto {

    private String userId;

    private String userName;

    private Boolean disabled;
}
