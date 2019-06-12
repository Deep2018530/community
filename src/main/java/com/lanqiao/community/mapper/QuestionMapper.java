package com.lanqiao.community.mapper;

import com.lanqiao.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DeepSleeping
 * @date 2019/6/12 23:44
 * @description
 */
@Mapper
public interface QuestionMapper {


    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
