package com.lanqiao.community.mapper;

import com.lanqiao.community.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/12 23:44
 * @description
 */
@Mapper
public interface QuestionMapper {


    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question")
    List<Question> list();

    @Select("select * from question where creator = #{userId}")
    List<Question> listByUserId(@Param("userId") Integer id);

    @Select("select * from question where id = #{id}")
    Question getById(@Param(value = "id") Integer id);

    @Update("update question set title = #{title},description = #{description},gmt_modified = #{gmtModified},tag = #{tag} where id = #{id}")
    void update(Question question);
}
