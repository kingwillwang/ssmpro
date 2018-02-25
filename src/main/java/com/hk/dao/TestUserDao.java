package com.hk.dao;

import com.hk.entity.TestUser;

import java.util.List;

public interface TestUserDao {
    List<TestUser> getUser();
    void addUser(TestUser testUser);
}
