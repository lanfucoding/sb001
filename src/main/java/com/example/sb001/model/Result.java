package com.example.sb001.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private boolean success;
    private T data;
    private String msg;

    public Result() {
    }

    public Result(int code, boolean success, String msg) {
        super();
        this.code = code;
        this.success = success;
        this.msg = msg;
    }
    //省略get/set 方法
}