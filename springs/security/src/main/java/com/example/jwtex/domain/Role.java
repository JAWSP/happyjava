package com.example.jwtex.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@Table(name = "roles")
@NoArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String name;

    //roles에 대하여 users를 굳이 안만들어도 된다
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;


    public Role(String name) {
        this.name = name;
    }
}
