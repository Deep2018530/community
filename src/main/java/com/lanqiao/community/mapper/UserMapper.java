package com.lanqiao.community.mapper;


import com.lanqiao.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author DeepSleeping
 * @date 2019/6/12 10:33
 * @description
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user_1(name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from user_1 where token = #{token}")
    User findByToken(@Param("token") String token);
}
