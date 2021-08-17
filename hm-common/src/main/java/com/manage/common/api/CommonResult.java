package com.manage.common.api;

import lombok.Data;

/**
 *
 * @author jonyon
 * @date 2021/6/14
 */
@Data
public class CommonResult<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;
    protected CommonResult(){
    }

    protected CommonResult(long code, String message, T data) {
        this.code=code;
        this.message=message;
        this.data=data;
    }


    /**
     * 成功返回结果
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }
    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     *失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }
    public static <T> CommonResult<T> failed(ErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }
    public static <T> CommonResult<T> failed(ErrorCode errorCode,String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}

