package com.elite.hospital.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Accessors(chain = true)
@Data
public class R implements Serializable {
    private static final long serialVersionUID = 1L;
    //代码值
    private long code;
    //信息
    private String msg;
    //数据
    private Object data;

    /**
     * 传入数据
     * @param data
     * @return
     */
    public static R ok( Object data) {
        R r = new R();
        r.setCode(200L).setMsg("成功").setData(data);
        return r;
    }
    public static R ok( ) {
        R r = new R();
        r.setCode(200L).setMsg("成功").setData(null);
        return r;
    }

    /**
     * 成功
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static R ok(Long code, String msg, Object data) {
        R r = new R();
        r.setCode(code).setMsg(msg).setData(data);
        return r;
    }

    /**
     *  错误
     */
    public static R fail(Long code, String msg) {

        R r = new R();
        r.setCode(code).setMsg(msg).setData(null);
        return r;
    }
}