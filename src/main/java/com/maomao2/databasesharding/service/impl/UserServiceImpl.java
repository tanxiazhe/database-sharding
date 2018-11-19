package com.maomao2.databasesharding.service.impl;

import com.maomao2.databasesharding.mapper.pkg2.UserMapper;
import com.maomao2.databasesharding.model.User;
import com.maomao2.databasesharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(long userId) {
        return userMapper.selectUserById(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userMapper.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}