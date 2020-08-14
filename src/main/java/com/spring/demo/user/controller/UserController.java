package com.spring.demo.user.controller;

import com.spring.demo.response.Message;
import com.spring.demo.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/v1.0/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/register")
    public Message register(String userName, String password){
        userService.saveUserEntity(userName, password);
        return Message.getSuccessData();
    }

}
