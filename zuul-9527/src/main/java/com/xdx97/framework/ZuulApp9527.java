package com.xdx97.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy
public class ZuulApp9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp9527.class, args);
    }
}