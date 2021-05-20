package com.jc.employee.domain;

import lombok.Data;

/**
 * @author LX
 * @date 2021/3/30
 */
@Data
public class BaseResult {
    private Integer code;
    private String msg;
    private Object data;

    public BaseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(Integer code, String msg, Object data) {
        this(code, msg);
        this.data = data;
    }

    public BaseResult(Integer code) {
        this.code = code;
    }

    public BaseResult() {
    }

    public BaseResult(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
}
