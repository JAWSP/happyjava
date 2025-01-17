package com.example.Iocex.repository;

import com.example.Iocex.domain.User;

import java.util.List;

//아까 그 DAO를 구현한데
public class UserDaoimpl implements UserDao {
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
        System.out.println(user+" 정보 저장");
    }
}
