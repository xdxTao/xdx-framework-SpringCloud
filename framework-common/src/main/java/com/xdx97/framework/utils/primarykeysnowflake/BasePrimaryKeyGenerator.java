package com.xdx97.framework.utils.primarykeysnowflake;

import java.io.Serializable;

/**
 * @author 小道仙
 * @date 2020年2月21日
 */
public interface BasePrimaryKeyGenerator {
    Serializable generate(Object entityObj);
}
