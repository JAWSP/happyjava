package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//테이블의 이름이 다르니
@Table(name="schools")
@Setter
@Getter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 225)
    private String name;

    //학생 리스트를 가질 수 있긴함
    //그리고 일대 다라는 부분을 명시해주고
    //mappedBy로 누가 연관관계의 주인인지 명시를 해줘야 함
    //저 school은 Student의 칼럼school이다
    @OneToMany(mappedBy = "school")
    private List<Student> students = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }
}
