package com.example.Iocex.service;

import com.example.Iocex.domain.User;
import com.example.Iocex.repository.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    @Override
    public void joinUser(User user) {
        userDao.addUser(user);
        System.out.println("대충 서비스 일하는중" + user.getName());
    }
}
