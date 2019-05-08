package com.example.userService;

import com.example.pojo.User;

public interface UserService {


    User selectOne(String id);

    User testZone();

    void insert(User user);
}
