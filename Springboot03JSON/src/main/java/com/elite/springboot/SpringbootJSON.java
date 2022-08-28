package com.elite.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 获取json数据
 */
@SpringBootApplication
public class SpringbootJSON
{
    public static void main( String[] args )
    {
        System.out.println("服务启动开始......");
        SpringApplication.run(SpringbootJSON.class,args);
        System.out.println("服务启动成功......");
    }
}
