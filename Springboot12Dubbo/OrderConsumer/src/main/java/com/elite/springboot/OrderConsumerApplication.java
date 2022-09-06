package com.elite.springboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDubbo //开启dubbo服务
@SpringBootApplication
public class OrderConsumerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderConsumerApplication.class,args);
    }
}
