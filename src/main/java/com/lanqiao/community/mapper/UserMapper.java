package com.lanqiao.community.mapper;


import com.lanqiao.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author DeepSleeping
 * @date 2019/6/12 10:33
 * @description
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user_1(name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user_1 where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user_1 where account_id = #{accountId} limit 0,1")
    User findById(@Param("accountId") Integer accountId);

    @Delete("delete from user_1 where account_id = #{accountId}")
    void removeAll(User user);

    @Select("select * from user_1 where account_id = #{accountId}")
    User findByaccountId(@Param(value = "accountId") String accountId);

    @Update("update user_1 set name = #{name},token = #{token},gmt_modified = #{gmtModified},avatar_url = #{avatarUrl} where account_id = #{accountId}")
    void update(User user);
}
