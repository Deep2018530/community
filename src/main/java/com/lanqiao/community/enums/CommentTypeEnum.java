package com.lanqiao.community.enums;

/**
 * @author DeepSleeping
 * @description
 * @date 2019/6/25 10:12
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
