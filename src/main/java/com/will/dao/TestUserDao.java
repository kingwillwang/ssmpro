package com.will.dao;

import com.will.entity.TestUser;

import java.util.List;

public interface TestUserDao {
    List<TestUser> getUser();
    void addUser(TestUser testUser);
}
