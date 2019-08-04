package com.lanqiao.community.controller;

import com.lanqiao.community.dto.CommentDTO;
import com.lanqiao.community.dto.ResponseResultDto;
import com.lanqiao.community.exception.CustomizeErrorCode;
import com.lanqiao.community.mapper.CommentMapper;
import com.lanqiao.community.model.Comment;
import com.lanqiao.community.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DeepSleeping
 * @date 2019/6/24 16:22
 * @description
 */
@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/comment")
    @ResponseBody
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request) {

        Object githubUser = request.getSession().getAttribute("githubUser");

        if (githubUser == null) {
            return ResponseResultDto.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(1);
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResponseResultDto.okOf();
    }
}
