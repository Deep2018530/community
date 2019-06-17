package com.lanqiao.community.dto;

import com.lanqiao.community.model.User;
import lombok.Data;

/**
 * @author DeepSleeping
 * @date 2019/6/14 10:49
 * @description
 */
@Data
public class QuestionDto {
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
    private User user;
}
