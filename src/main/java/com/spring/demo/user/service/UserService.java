package com.spring.demo.user.service;


import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void saveUserEntity(String userName, String password);
}
