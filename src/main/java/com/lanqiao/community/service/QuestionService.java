package com.lanqiao.community.service;

import com.lanqiao.community.dto.QuestionDto;
import com.lanqiao.community.exception.CustomizeErrorCode;
import com.lanqiao.community.exception.CustomizeException;
import com.lanqiao.community.mapper.QuestionExtMapper;
import com.lanqiao.community.mapper.QuestionMapper;
import com.lanqiao.community.mapper.UserMapper;
import com.lanqiao.community.model.Question;
import com.lanqiao.community.model.QuestionExample;
import com.lanqiao.community.model.User;
import com.lanqiao.community.model.UserExample;
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


    @Autowired
    private QuestionExtMapper questionExtMapper;

    /**
     * @description 获取所有帖子(因pagehelper的问题 ， 单独执行sql转换dto)
     * @author DeepSleeping
     * @date 2019/6/17 10:12
     */
    public List<Question> listQuestion() {
        List<Question> questions = questionMapper.selectByExample(null);
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
            UserExample example = new UserExample();
            example.createCriteria().andAccountIdEqualTo(questionDto.getCreator().toString());
            List<User> users = userMapper.selectByExample(example);
            questionDto.setUser(users.get(0));
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
        QuestionExample example = new QuestionExample();
        example.createCriteria().andIdEqualTo(id);
        List<Question> questions = questionMapper.selectByExample(example);

        return questions;
    }

    /**
     * @description 根据id查询问题
     * @author DeepSleeping
     * @date 2019/6/18 23:13
     */
    public QuestionDto getById(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(questionDto.getCreator().toString());
        List<User> users = userMapper.selectByExample(userExample);
        questionDto.setUser(users.get(0));
        return questionDto;
    }

    /**
     * @description 发布问题的时候判断是 新增还是修改
     * @author DeepSleeping
     * @date 2019/6/19 15:04
     */
    public void createOrUpdate(Question question) {
        if (ObjectUtils.isEmpty(question.getId())) {
            //创建
            question.setViewCount(0);
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        } else {
            //更新
            question.setGmtModified(System.currentTimeMillis());
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria().andIdEqualTo(question.getId());
            int updated = questionMapper.updateByExampleSelective(question, questionExample);
            if (updated != 1) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    /**
     * @description 累加阅读数
     * @author DeepSleeping
     * @date 2019/6/24 10:33
     */
    public void incView(Integer id) {
        Question question = new Question();
        question.setId(id);
        //sql语句是view_count+ 1（viewCount）
        question.setViewCount(1);
        questionExtMapper.incView(question);
    }
}
