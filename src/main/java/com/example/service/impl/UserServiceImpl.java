package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectOne(String id) {
        User user = userMapper.selectOne(id);
        return user;
    }

    @Override
    public User testZone() {
        User date = userMapper.now();
        return date;
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }


}
