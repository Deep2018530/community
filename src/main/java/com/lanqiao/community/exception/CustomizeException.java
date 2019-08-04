package com.lanqiao.community.exception;

/**
 * @author DeepSleeping
 * @date 2019/6/23 23:37
 * @description
 */
public class CustomizeException extends RuntimeException {
    private String message;

    private Integer code;

    public CustomizeException(String message) {
        this.message = message;
    }

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
