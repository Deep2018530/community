package com.lanqiao.community.model;

import lombok.Data;

/**
 * @author DeepSleeping
 * @date 2019/6/12 23:47
 * @description
 */
@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
