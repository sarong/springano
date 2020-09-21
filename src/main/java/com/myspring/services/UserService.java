package com.myspring.services;

import com.myspring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class UserService {
    @Inject
//    @Resource
//    @Autowired
    UserDao userDao;

    public void printUserDao(){
        System.out.println(userDao);
    }
}
