package com.lanqiao.community.service;

import com.lanqiao.community.mapper.UserMapper;
import com.lanqiao.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author DeepSleeping
 * @date 2019/6/19 00:28
 * @description
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public void createOrUpdate(User user) {
        User dbuser = userMapper.findByaccountId(user.getAccountId());
        if (ObjectUtils.isEmpty(dbuser)){
            userMapper.insert(user);
        } else {
            dbuser.setGmtModified(System.currentTimeMillis());
            dbuser.setAvatarUrl(user.getAvatarUrl());
            dbuser.setName(user.getName());
            dbuser.setToken(user.getToken());
            userMapper.update(user);
        }

    }
}
