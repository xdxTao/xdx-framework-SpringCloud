package com.xdx97.framework.utils;

import java.util.UUID;

/**
 * UUIDUtils
 *
 * @author 小道仙
 * @date 2020年2月18日
 */
public class UUIDUtils {
    public UUIDUtils() {
    }
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
