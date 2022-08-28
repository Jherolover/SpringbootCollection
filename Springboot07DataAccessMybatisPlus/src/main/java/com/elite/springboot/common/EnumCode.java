package com.elite.springboot.common;

import lombok.Data;
import lombok.Getter;
import org.apache.ibatis.annotations.Insert;

/**
 * 错误代码
 */
@Getter
public enum EnumCode {

    FAILED(400, "操作失败"),
    SUCCESS(200, "执行成功"),
    PASSWORDERROR(300,"密码错误");

    private final Integer code;
    private final String msg;

    private EnumCode(final  Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
}
