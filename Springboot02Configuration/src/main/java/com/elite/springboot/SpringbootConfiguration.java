package com.elite.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置属性的获取
 */
@SpringBootApplication
public class SpringbootConfiguration {
    public static void main(String[] args) {
        System.out.println("服务启动开始");
        SpringApplication.run(SpringbootConfiguration.class,args);
        System.out.println("服务启动结束");
    }
}
