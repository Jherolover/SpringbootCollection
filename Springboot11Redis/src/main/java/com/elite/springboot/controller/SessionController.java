package com.elite.springboot.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * session控制类
 */
@RestController
public class SessionController {

    //设置session
    @GetMapping("/setSession/{username}")
    public String setSession(HttpSession httpSession,@PathVariable("username") String username){
        httpSession.setAttribute("username",username);
        return "OK";
    }
    //获取session
    @GetMapping("/getSession")
    public Object getSession(HttpSession httpSession){
        Object username = httpSession.getAttribute("username");
        return username;
    }
}
