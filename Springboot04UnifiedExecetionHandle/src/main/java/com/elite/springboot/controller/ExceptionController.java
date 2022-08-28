package com.elite.springboot.controller;

import com.elite.springboot.common.ErrorEnum;
import com.elite.springboot.common.R;
import com.elite.springboot.exception.MyException;
import org.springframework.web.bind.annotation.*;

/**
 * 测试异常类controller
 */
@RequestMapping
@RestController
public class ExceptionController {


    //空指针异常
    @GetMapping("/exception1")
    public R test1(){
        String s = null;
        boolean equals = s.equals("");
        return R.ok(null);
    }
    //运算异常
    @GetMapping("/exception2")
    public R test2(){
        int i = 5/0 ;
        return R.ok(null);
    }
}
