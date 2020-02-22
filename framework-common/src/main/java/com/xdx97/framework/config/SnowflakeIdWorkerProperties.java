package com.xdx97.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 雪花算法 workId
 */
@Configuration
public class SnowflakeIdWorkerProperties {
	/** 工作机器ID(0~31) */
	private static long workerId;

	/** 数据中心ID (0~31)(0~31) */
	private static long datacenterId;

	@Value("${jdbc.snowflakeId.workerId:0}")
	public void setWorkerId(long workerId) {
		SnowflakeIdWorkerProperties.workerId = workerId;
	}

	@Value("${jdbc.snowflakeId.datacenterId:0}")
	public void setDatacenterId(long datacenterId) {
		SnowflakeIdWorkerProperties.datacenterId = datacenterId;
	}

	public static long getWorkerId() {
		return workerId;
	}

	public static long getDatacenterId() {
		return datacenterId;
	}
}

