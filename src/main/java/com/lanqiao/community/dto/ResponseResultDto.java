package com.lanqiao.community.dto;

import lombok.Data;

/**
 * @author DeepSleeping
 * @date 2019/6/25 10:07
 * @description
 */
@Data
public class ResponseResultDto {
    private Integer code;
    private String message;


    public static ResponseResultDto errorOf(Integer code, String message) {
        ResponseResultDto resultDto = new ResponseResultDto();
        resultDto.setCode(code);
        resultDto.setMessage(message);
        return resultDto;
    }
}
