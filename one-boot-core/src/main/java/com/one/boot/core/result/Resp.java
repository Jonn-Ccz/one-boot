package com.one.boot.core.result;

import lombok.Data;

/**
 * Created by jonn
 * Date: 2021/5/7 4:12 下午
 * Description:
 */
@Data
public class Resp<T> {
    private int code; // 返回码

    private String description; // 描述

    private T result; // 返回信息

    public Resp() {
    }

    public Resp(RespCode code) {
        this.code = code.getCode();
        this.description = code.getDescription();
    }

    public Resp(RespCode code, T result) {
        this.code = code.getCode();
        this.description = code.getDescription();
        this.result = result;
    }

    public Resp(int code) {
        this.code = code;
    }

    public Resp(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Resp(int code, String description, T result) {
        this.code = code;
        this.description = description;
        this.result = result;
    }

}
