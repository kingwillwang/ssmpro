package com.hk.service.impl;

import com.hk.dao.TestUserDao;
import com.hk.entity.TestUser;
import com.hk.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestUserServiceImpl implements TestUserService {
    //注入依赖
    @Autowired
    private TestUserDao testUserDao;

    /**
     * 使用注解控制事务方法的优点
     * 1：开发团队达成一致的约定，明确标注事务方法的编码规范
     * 2：保证事务方法的执行时间尽可能短，不要穿插其他网络操作 如HTTP操作或者剥离事务外部方法
     * 3：不是所有的方法都需要事务，如果有一条修改操作 只读操作 不需要事务控制
     */
    @Transactional
    public List<String> getAllUserName() {
        List<TestUser> t = testUserDao.getUser();

        List<String> allName = new ArrayList();
        for (TestUser tt : t) {
            allName.add(tt.getUserName());
        }
        return allName;
    }

    public List<TestUser> userList() {
        return testUserDao.getUser();
    }
}
