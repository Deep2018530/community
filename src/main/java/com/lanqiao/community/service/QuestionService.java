package com.lanqiao.community.service;

import com.lanqiao.community.dto.QuestionDto;
import com.lanqiao.community.mapper.QuestionMapper;
import com.lanqiao.community.mapper.UserMapper;
import com.lanqiao.community.model.Question;
import com.lanqiao.community.model.User;
import javafx.beans.property.Property;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/14 10:50
 * @description
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * @description 获取所有帖子(因pagehelper的问题 ， 单独执行sql转换dto)
     * @author DeepSleeping
     * @date 2019/6/17 10:12
     */
    public List<Question> listQuestion() {
        List<Question> questions = questionMapper.list();
        return questions;
    }

    /**
     * @description 将帖子转换成传输dto
     * @author DeepSleeping
     * @date 2019/6/17 10:13
     */
    public List<QuestionDto> listQuestionDto(List<Question> questions) {
        List<QuestionDto> questionDtos = new ArrayList<>();
        for (Question question : questions) {
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
            User user = userMapper.findById(questionDto.getCreator());
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        return questionDtos;
    }

    /**
     * @description 根据用户id查询问题
     * @author DeepSleeping
     * @date 2019/6/17 11:37
     */
    public List<Question> listQuestion(Integer id) {
        List<Question> questions = questionMapper.listByUserId(id);

        return questions;
    }

    /**
     * @description 根据id查询问题
     * @author DeepSleeping
     * @date 2019/6/18 23:13
     */
    public QuestionDto getById(Integer id) {
        Question question = questionMapper.getById(id);
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        User user = userMapper.findById(questionDto.getCreator());
        questionDto.setUser(user);
        return questionDto;
    }
}
