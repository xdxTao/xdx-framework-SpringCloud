package com.xdx97.framework.listener;

import com.xdx97.framework.utils.pay.AlipayProperties;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * 配置文件监听器，用来加载自定义配置文件
 * @author 小道仙
 * @date 2020年2月17日
 */
@Component
public class PropertiesListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        AlipayProperties.loadProperties();
    }
}