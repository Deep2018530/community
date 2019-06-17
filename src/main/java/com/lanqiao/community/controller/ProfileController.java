package com.lanqiao.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.community.common.constant.PaginationConstant;
import com.lanqiao.community.dto.QuestionDto;
import com.lanqiao.community.model.Question;
import com.lanqiao.community.model.User;
import com.lanqiao.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/17 11:11
 * @description
 */
@Controller
public class ProfileController {


    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                          Model model) {

        User user = (User) request.getSession().getAttribute("githubUser");
        if (ObjectUtils.isEmpty(user)) {
            return "redirect:/";
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", action);
            model.addAttribute("sectionName", "我的提问");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", action);
            model.addAttribute("sectionName", "最新回复");
        }
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        List<Question> questionList = questionService.listQuestion(Integer.valueOf(user.getAccountId()));
        PageInfo<Question> pageInfo = new PageInfo<Question>(questionList);

        PageInfo<QuestionDto> pageInfo_Dto = new PageInfo<QuestionDto>();
        BeanUtils.copyProperties(pageInfo, pageInfo_Dto);
        pageInfo_Dto.setList(questionService.listQuestionDto(questionList));
        model.addAttribute("pageInfo", pageInfo_Dto);
        return "profile";
    }
}
