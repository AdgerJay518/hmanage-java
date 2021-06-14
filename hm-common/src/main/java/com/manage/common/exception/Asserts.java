package com.manage.common.exception;

import com.manage.common.api.ErrorCode;

/**
 * 断言处理
 * @author 吴政杰
 */
public class Asserts {
    public static void fail(String message) {
        throw new Exception(message);
    }

    public static void fail(ErrorCode errorCode) {
        throw new Exception(errorCode);
    }
}
