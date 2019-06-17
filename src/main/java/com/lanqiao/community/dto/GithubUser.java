package com.lanqiao.community.dto;

import lombok.Data;

/**
 * @author DeepSleeping
 * @date 2019/6/11 09:56
 * @description
 */
@Data
public class GithubUser {

    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;

}
