package com.lanqiao.community.controller;

import com.lanqiao.community.mapper.UserMapper;
import com.lanqiao.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author DeepSleeping
 * @date 2019/6/10 23:17
 * @description
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (!ObjectUtils.isEmpty(user)) {
                    request.getSession().setAttribute("githubUser", user);
                }
                break;
            }
        }


        return "index";
    }
}
