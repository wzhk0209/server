package com.spring.demo.user.service.impl;

import com.spring.demo.dao.BaseDaoTools;
import com.spring.demo.entity.UserEntity;
import com.spring.demo.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource
    protected BaseDaoTools baseDaoTools;

    @Override
    public void saveUserEntity(String  userName, String password) {
        UserEntity userEntity = new UserEntity(userName, password);
        baseDaoTools.saveEntity(userEntity);
    }
}
