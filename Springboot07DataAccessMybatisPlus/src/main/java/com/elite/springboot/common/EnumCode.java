package com.elite.hospital.common;

import lombok.Data;

/**
 * 错误代码
 */
public enum EnumCode {

    FAILED(400L, "操作失败"),
    SUCCESS(200L, "执行成功");

    private final Long code;
    private final String msg;

    private EnumCode(final  Long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
}
