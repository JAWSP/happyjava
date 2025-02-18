package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter @Setter
@NoArgsConstructor
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    String name;

    //직원과 프로젝트는 다대다
    //이건 아마 테이블간의 관계를 나타내는 테이블
    //join는 내쪽
    //inverse는 상대쪽
    //만약 테이블이 안만들어졌다면
    @ManyToMany
    @JoinTable (
            name = "employees_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Set<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    //근데 객체안에 객체 안에 객체안에 객체... 를 계속 채울 수 있어서
    //toString시 객체에 대한 부분은 제한다
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
