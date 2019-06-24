package com.lanqiao.community.controller;

import com.lanqiao.community.dto.CommentDTO;
import com.lanqiao.community.mapper.CommentMapper;
import com.lanqiao.community.model.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DeepSleeping
 * @date 2019/6/24 16:22
 * @description
 */
@Controller
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @PostMapping(value = "/comment")
    @ResponseBody
    public Object post(@RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(1);
        comment.setLikeCount(0L);
        commentMapper.insert(comment);
        return null;
    }
}
