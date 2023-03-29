package com.xiaozhi.utils;

import lombok.Data;

/**
 * @author xiaozhi
 * @description 全局统一返回结果类
 * @create 2021-07-2021/7/12 15:16
 */
@Data
public class Result<T> {
    // 状态码
    private Integer code;

    private Long count;

    // 返回消息
    private String message;

    // 数据
    private T data;

    public Result() {
    }

    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum, Long count) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        // TODO 总页数
        result.setCount(count);
        return result;
    }

    public static <T> Result<T> build(Integer code, String message) {
        Result<T> result = build(null);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> ok() {
        return Result.ok(null, null);
    }

    /**
     * 操作成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T data, Long count) {
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS, count);
    }

    public static <T> Result<T> fail() {
        return Result.fail(null, null);
    }

    /**
     * 操作失败
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(T data, Long count) {
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.FAIL, count);
    }

    public Result<T> message(String msg) {
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public boolean isOk() {
        if (this.getCode().intValue() == ResultCodeEnum.SUCCESS.getCode().intValue()) {
            return true;
        }
        return false;
    }
}
