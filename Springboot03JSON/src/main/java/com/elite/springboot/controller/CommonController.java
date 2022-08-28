package com.elite.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.elite.springboot.Common.R;
import com.elite.springboot.entity.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
//@Controller
//@ResponseBody
public class CommonController {


    //不带返回数据的格式
    @GetMapping("/ok1")
    public R ok1(){
        return R.ok(null);
    }
    //因为注解restcontroller => @controller + @ResponseBody
    //带有返回数据的json格式
    @GetMapping("/ok2")
    public R ok2(){
        User u = new User();
        u.setUserName("牛奶糖");
        u.setAge(22);
        u.setAddress("xxx省");
        return R.ok(200,"成功",u);
    }
    //带有返回数据的json格式
    @GetMapping("/fail")
    public R fail(){
        return R.fail();
    }

    //使用json转换工具转换返回数据fastjson
    @GetMapping("/fastjson")
    public String fastjson(){
        User u = new User();
        u.setUserName("牛奶糖");
        u.setAge(22);
        u.setAddress("xxx省");
        R r = R.ok(u);
        return JSON.toJSONString(r);
    }

    //使用json转换工具转换返回数据fastjson
    @GetMapping("/gson")
    public String gson(){
        User u = new User();
        u.setUserName("牛奶糖");
        u.setAge(22);
        u.setAddress("xxx省");
        R r = R.ok(u);
        Gson gson = new Gson();
        return gson.toJson(r);
    }
}
