package com.example.boardpratice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@Table("Board")
public class Board {
    @Id
   // @Column("board_id")
    private Long id;
    private String name;
    private String title;
    //비밀번호 해싱?
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //난 왜 매핑이 안되냐
    //@MappedCollection(idColumn = "board_id")
//    private final List<Comment> comments = new ArrayList<>();
//
//    public void addComment(Comment comment) {
//        comments.add(comment);
//    }
}
