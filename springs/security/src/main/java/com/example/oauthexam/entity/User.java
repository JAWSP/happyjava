package com.example.oauthexam.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "lion_users")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false)
    private LocalDateTime registration_date = LocalDateTime.now();


    //AOuth에 필요한 컬럼을 2개 더 추가
    @Column(name = "social_id")
    private String socialId;
    private String provider;


    //유저 정보 꺼낼때 roles안의 정보를 다 봐야 하니 한번에 다 가져온다
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            //그 테이블의 이름
            name = "user_roles",
            //주가 되는 놈의 칼럼
            joinColumns = @JoinColumn(name = "user_id"),
            //관계의 반대쪽 칼럼
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> Roles;

    public User(String username, String password, String name, String email, LocalDate registration_date) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}

