package com.elite.springboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.elite.springboot.mapper")
public class SpringbootMybatisPlusApp
{
    public static void main( String[] args ) {
        SpringApplication.run(SpringbootMybatisPlusApp.class,args);
    }
}
