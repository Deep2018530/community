package com.lanqiao.community.dto;

import lombok.Data;

/**
 * @author DeepSleeping
 * @date 2019/6/11 09:38
 * @description
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
