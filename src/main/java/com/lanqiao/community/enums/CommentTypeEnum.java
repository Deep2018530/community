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

    /**
     * create by zhangdingping on 2019/8/4 16:26
     */
    public static boolean isExist(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if (value.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
