package com.hk.controller;

import com.hk.entity.TestUser;
import com.hk.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/hk")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String getListPage(){
        return "list";
    }

    @RequestMapping(value="/userList",method = RequestMethod.GET)
    @ResponseBody
    public List<TestUser> getList(){
        return testUserService.userList();
    }

}
