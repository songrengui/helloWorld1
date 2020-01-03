package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
@Autowired
    UserDao userDao;

    @Override
    public List<User> queryAll() {
        System.out.println("业务层代码执行了");
        return userDao.queryAll();
    }
}
