package com.manage.common.exception;

import com.manage.common.api.ErrorCode;

/**
 * 自定义异常
 * @author 吴政杰
 */
public class Exception extends RuntimeException{
    private ErrorCode errorCode;
    public Exception(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public Exception(String message) {
        super(message);
    }

    public Exception(Throwable cause) {
        super(cause);
    }

    public Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
