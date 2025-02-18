package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//테이블의 이름이 다르니
@Table(name="schools")
@Setter
@Getter
@NoArgsConstructor
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
    //cascade는 영속성의 전이를
    //orphan는 부모가 죽었을 경우 자식은 어찌 처리할것이냐
    @OneToMany(mappedBy = "school", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public School(String name) {
    }

}
