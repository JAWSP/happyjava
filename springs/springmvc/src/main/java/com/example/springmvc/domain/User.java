package com.example.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private boolean isAdmin;
}
