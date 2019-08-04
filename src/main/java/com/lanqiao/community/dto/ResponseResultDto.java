package com.lanqiao.community.dto;

import com.lanqiao.community.exception.CustomizeErrorCode;
import com.lanqiao.community.exception.CustomizeException;
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

    public static ResponseResultDto errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(), errorCode.getMessage());
    }

    /**
     * create by zhangdingping on 2019/8/4 16:10
     */
    public static ResponseResultDto errorOf(CustomizeException ex) {
        return ResponseResultDto.errorOf(ex.getCode(), ex.getMessage());
    }

    public static ResponseResultDto okOf() {
        ResponseResultDto resultDto = new ResponseResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("请求成功");
        return resultDto;
    }


}
