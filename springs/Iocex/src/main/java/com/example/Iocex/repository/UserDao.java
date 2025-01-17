package com.example.Iocex.repository;

import com.example.Iocex.domain.User;

import java.util.List;

//요새는 Dao보단 repository라고 한다
public interface UserDao {
    public User getUser(String email);
    public List<User> getUsers();
    public void addUser(User user);
}
