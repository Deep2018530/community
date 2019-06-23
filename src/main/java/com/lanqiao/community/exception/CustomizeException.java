package com.lanqiao.community.exception;

/**
 * @author DeepSleeping
 * @date 2019/6/23 23:37
 * @description
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(String message) {
        this.message = message;
    }

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
