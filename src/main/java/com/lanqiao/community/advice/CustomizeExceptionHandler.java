package com.lanqiao.community.advice;

import com.lanqiao.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DeepSleeping
 * @date 2019/6/23 23:30
 * @description
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model) {
        if (ex instanceof CustomizeException) {
            model.addAttribute("message", ex.getMessage());
        } else {
            model.addAttribute("message", "服务冒烟了，要不然你稍后再试试！！！");
        }
        return new ModelAndView("error");
    }

}
