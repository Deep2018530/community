package com.lanqiao.community.service;

import com.lanqiao.community.mapper.CommentMapper;
import com.lanqiao.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DeepSleeping
 * @date 2019/6/25 10:14
 * @description
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0){

        }
    }
}
