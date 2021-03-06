package com.lanqiao.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.community.common.constant.PaginationConstant;
import com.lanqiao.community.dto.QuestionDto;
import com.lanqiao.community.model.Question;
import com.lanqiao.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/10 23:17
 * @description
 */
@Controller
public class IndexController {
    
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        /**
         * pagehelper只对下面第一条sql起作用，原来的service中有多条sql,现在先差一个然后再设置list
         */
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        List<Question> questionList = questionService.listQuestion();
        PageInfo<Question> pageInfo = new PageInfo<Question>(questionList);

        PageInfo<QuestionDto> pageInfo_Dto = new PageInfo<QuestionDto>();
        BeanUtils.copyProperties(pageInfo, pageInfo_Dto);
        pageInfo_Dto.setList(questionService.listQuestionDto(questionList));

        model.addAttribute("pageInfo", pageInfo_Dto);
        return "index";
    }
}
