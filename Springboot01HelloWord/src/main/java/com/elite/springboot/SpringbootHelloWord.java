package com.elite.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootHelloWord {
    public static void main(String[] args) {
        System.out.println("服务启动开始");
        SpringApplication.run(SpringbootHelloWord.class,args);
        System.out.println("服务启动结束");
    }
}
