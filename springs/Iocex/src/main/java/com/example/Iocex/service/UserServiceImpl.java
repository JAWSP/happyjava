package com.example.Iocex.service;

import com.example.Iocex.domain.User;
import com.example.Iocex.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//이 또한 컴포넌트의 자손
@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {
        userDao.addUser(user);
        System.out.println("대충 서비스 일하는중" + user.getName());
    }
}
