package com.xy.blog.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMsg("请求成功!");
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMsg("请求成功!")
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMsg(message);
    }
}
