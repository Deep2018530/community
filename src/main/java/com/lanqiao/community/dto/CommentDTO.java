package com.lanqiao.community.dto;

import lombok.Data;

/**
 * @author DeepSleeping
 * @date 2019/6/24 16:27
 * @description 1
 */
@Data
public class CommentDTO {

    private Long parentId;
    private String content;
    private Integer type;
}
