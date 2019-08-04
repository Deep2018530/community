package com.lanqiao.community.advice;

import com.alibaba.fastjson.JSON;
import com.lanqiao.community.dto.ResponseResultDto;
import com.lanqiao.community.exception.CustomizeErrorCode;
import com.lanqiao.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author DeepSleeping
 * @date 2019/6/23 23:30
 * @description
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response) {
        String contentType = request.getContentType();

        if ("application/json".equals(contentType)) {
            ResponseResultDto resultDto;
            //返回json
            //页面跳转
            if (ex instanceof CustomizeException) {
                resultDto = ResponseResultDto.errorOf((CustomizeException) ex);
            } else {
                resultDto = ResponseResultDto.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            response.setContentType("application/json");
            response.setStatus(200);
            response.setCharacterEncoding("utf-8");
            try (PrintWriter writer = response.getWriter()) {
                writer.write(JSON.toJSONString(resultDto));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            //页面跳转
            if (ex instanceof CustomizeException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }


    }

}
