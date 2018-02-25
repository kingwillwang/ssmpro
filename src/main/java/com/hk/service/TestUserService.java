package com.hk.service;

import com.hk.entity.TestUser;

import java.util.List;

public interface TestUserService {
    List<String> getAllUserName();

    List<TestUser> userList();
}
