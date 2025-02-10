package com.example.boardpratice.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {
    @Id
    private Long id;
    private String name;
    private String title;
    //비밀번호 해싱?
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
