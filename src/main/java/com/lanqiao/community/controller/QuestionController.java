package com.lanqiao.community.controller;

import com.lanqiao.community.dto.QuestionDto;
import com.lanqiao.community.mapper.QuestionExtMapper;
import com.lanqiao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author DeepSleeping
 * @date 2019/6/18 23:10
 * @description
 */
@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;



    @GetMapping(value = "question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model) {
        QuestionDto questionDto = questionService.getById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDto);
        return "question";
    }
}
