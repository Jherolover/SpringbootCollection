package com.elite.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
//需要扫描实体
@EntityScan("com.elite.springboot.Entity")
public class SpringbootJPA {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJPA.class,args);
    }

}
