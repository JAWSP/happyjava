package com.example.Iocex.domain;

import com.example.Iocex.repository.UserDao;
import org.springframework.stereotype.Component;

//@Component
public class User {
    private String name;
    private String email;
    private String password;

    public User() {
        System.out.println("유저 만들었다 이말이야");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}