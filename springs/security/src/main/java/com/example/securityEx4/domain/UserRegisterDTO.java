package com.example.securityEx4.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserRegisterDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    //날짜까지 선언하지 않는 이유는 이렇게

    private Set<String> Roles;
}
