package com.elite.springboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.elite.springboot.mapper")
public class SpringbootSwaggerApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(SpringbootSwaggerApplication.class,args);
    }
}
