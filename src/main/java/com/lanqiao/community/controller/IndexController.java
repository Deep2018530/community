package com.lanqiao.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author DeepSleeping
 * @date 2019/6/10 23:17
 * @description
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String hello() {
        return "index";
    }
}
