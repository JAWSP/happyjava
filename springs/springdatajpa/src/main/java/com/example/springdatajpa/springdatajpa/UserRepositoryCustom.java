package com.example.springdatajpa.springdatajpa;

import java.util.List;

//이번엔 내가 별도로 레포지토리를 구현할거임
//그게 바로 criteria
public interface UserRepositoryCustom {
    List<User> findUserByName(String name);
    List<User> findUsersDynamically(String name, String email);
}
