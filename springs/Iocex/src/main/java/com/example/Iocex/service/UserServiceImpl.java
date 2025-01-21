package com.example.Iocex.service;

import com.example.Iocex.domain.User;
import com.example.Iocex.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//이 또한 컴포넌트의 자손
@Service("userService")
public class UserServiceImpl implements UserService{
    private UserDao userDao;

   // public UserServiceImpl() {}


    //얜 생성자가 하나이상이면 Autowired를 넣으면 된다
  //  @Autowired
    public UserServiceImpl(@Qualifier("userTmpDao") UserDao userDao) {
        this.userDao = userDao;
    }

    //@Autowired
    //@Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {
        userDao.addUser(user);
        System.out.println("대충 서비스 일하는중" + user.getName());
    }
}
