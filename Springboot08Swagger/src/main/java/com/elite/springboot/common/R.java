package com.elite.springboot.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Accessors(chain = true)
@Data
public class R implements Serializable {
    //请求返回的代码
    private Integer code;
    //请求的信息
    private String msg;
    //数据
    private Object data;

    //成功
    public static R ok(Object data){
        return new R().setCode(200).setMsg("成功").setData(data);
    }
    //成功
    public static R ok(Integer code,String msg,Object data){
        return new R().setCode(code).setMsg(msg).setData(data);
    }
    //失败
    public static R fail(){
        return new R().setCode(400).setMsg("请求失败！");
    }
    //失败
    public static R fail(Integer code,String msg){
        return new R().setCode(code).setMsg(msg).setData(null);
    }
}