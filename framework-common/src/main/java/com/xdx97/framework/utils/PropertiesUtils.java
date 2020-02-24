package com.xdx97.framework.utils;

import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

public class PropertiesUtils {
	private static Environment env;

	public static void setEnvironment(Environment env) {
		PropertiesUtils.env = env;
	}


	/**
	 * Get a value based on key , if key does not exist , null is returned
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key, String defaultValue) {
		String value = env.getProperty(key);
		return StringUtils.isEmpty(value) ? defaultValue : value;
	}
}
