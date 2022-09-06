package com.elite.springboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo  //开启dubbo服务
public class OrderProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class,args);
    }
}
