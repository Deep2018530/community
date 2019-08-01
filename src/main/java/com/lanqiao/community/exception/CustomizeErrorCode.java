package com.lanqiao.community.exception;

/**
 * @author DeepSleeping
 * @description
 * @date 2019/6/23 23:56
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "你找的问题不在了，要不换个试试？");

    private String message;

    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
