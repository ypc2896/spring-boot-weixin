package com.xy.blog.core;

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String message) {
        this.msg = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}
