package com.elite.springboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务启动类
 */
@SpringBootApplication
@MapperScan("com.elite.springboot.mapper")
public class SpringbootVueApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(SpringbootVueApplication.class,args);
    }
}
