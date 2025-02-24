package com.example.rest.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ex_user")
@Getter
@Setter
@NoArgsConstructor
public class ExUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public ExUser(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
