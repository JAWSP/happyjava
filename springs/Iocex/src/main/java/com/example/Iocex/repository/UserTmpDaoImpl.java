package com.example.Iocex.repository;

import com.example.Iocex.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userTmpDao")
public class UserTmpDaoImpl implements UserDao{
    UserTmpDaoImpl() {
        System.out.println("asd");
    }

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "잘나옴?");
    }
}
