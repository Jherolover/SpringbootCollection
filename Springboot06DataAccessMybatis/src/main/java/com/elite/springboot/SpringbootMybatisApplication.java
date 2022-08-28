package com.elite.springboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//使用MapperScan批量扫描所有的Mapper接口；
@MapperScan(value = "com.elite.springboot.mapper")
@SpringBootApplication
public class SpringbootMybatisApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(SpringbootMybatisApplication.class,args);
    }
}
