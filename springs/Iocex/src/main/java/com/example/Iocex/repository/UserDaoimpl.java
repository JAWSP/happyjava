package com.example.Iocex.repository;

import com.example.Iocex.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sample.bean.Player;

import java.util.List;

//아까 그 DAO를 구현한데
//@Component
@Repository("userDaoImpl")
public class UserDaoimpl implements UserDao {
    private List<User> users;

    public UserDaoimpl() {
        System.out.println("aa");
    }

    public UserDaoimpl(List<User> users) {
        this.users = users;
    }

    @Override
    public User getUser(String email) {
        for (User user: users) {
            if (user.getEmail().equals(email))
                return user;
        }
        System.out.println("없네용");
        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        //users.add(user);
        System.out.println(user+" 정보 저장");
    }
}
