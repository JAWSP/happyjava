package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //학생과 학교는 다대일 관계이다
    @ManyToOne
    //그리고 학교의 칼럼이 들어간다
    @JoinColumn(name = "school_id")
    private School school;

}
