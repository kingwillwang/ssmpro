package com.will.service;

import com.will.entity.TestUser;

import java.util.List;

public interface TestUserService {
    List<String> getAllUserName();

    List<TestUser> userList();
}
