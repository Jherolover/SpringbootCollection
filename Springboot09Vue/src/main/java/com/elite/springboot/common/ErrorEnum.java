package com.elite.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一错误枚举类
 */

@Getter
@AllArgsConstructor //全参数构造器
public enum ErrorEnum {
    SUCCESS(200,"请求成功"),
    FAIL(400,"请求错误"),
    SERVERERROR(500,"服务器内部错误"),
    PASSWORDERROR(10001,"密码错误"),
    PARAMETERERROE(10002,"请求参数错误"),
    NPERROR(10003,"空指针异常"),
    DIVERROR(10004,"除数异常"),
    MYEXCEPTION(10005,"自定义异常")
    // ....等等
     ;
    private Integer code;
    private String message;

}
