package com.elite.springboot.controller;

import com.elite.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    //引入缓存操作
    @Autowired
    RedisService redisService;

    @GetMapping("/redistest")
    public String hello(){
        return "hello,spring integration with redis";
    }
    @GetMapping("/redis/{key}/{val}")
    public String savekeyValue(@PathVariable("key") String key, @PathVariable("val") Object val){
        redisService.saveKeyValue(key,val);
        return key+"="+redisService.getValueByKey(key);
    }

    @GetMapping("/redis/{key}")
    public String getValueByKey(@PathVariable("key") String key){
        return redisService.getValueByKey(key);
    }

    @GetMapping("/redis/delete/{key}")
    public String delete(@PathVariable("key") String key){
       redisService.delete(key);
       return redisService.getValueByKey(key);
    }
}
