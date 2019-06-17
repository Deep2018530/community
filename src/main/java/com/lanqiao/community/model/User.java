package com.lanqiao.community.model;

import lombok.Data;

/**
 * @author DeepSleeping
 * @date 2019/6/12 10:36
 * @description
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    /**
     * 图片地址
     */
    private String avatarUrl;

}
