package com.xdx97.framework.utils.primarykeysnowflake;

import com.xdx97.framework.config.SnowflakeIdWorkerProperties;

/**
 * 雪花算法key
 *
 * @author  小道仙
 * @date 2020年7月21日
 */
public class PrimaryKeySnowflakeGenerator implements BasePrimaryKeyGenerator {
    @Override
    public String generate(Object entityObj) {
        //获取workId
        Long workId = SnowflakeIdWorkerProperties.getWorkerId();
        Long datacenterId = SnowflakeIdWorkerProperties.getDatacenterId();
        long id = SnowflakeIdWorker.getSingleInstance(workId, datacenterId).nextId();
        return  String.valueOf(id);
    }
}
