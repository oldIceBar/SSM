package com.ice.service.impl;

import com.ice.dao.UserMapper;
import com.ice.service.UserService;
import com.ice.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    HashMap a = new HashMap();
    @Override
    public User findUserById(long userId) {
        return userMapper.selectUserById(userId);
    }
}
