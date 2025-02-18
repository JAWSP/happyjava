package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//MappedSuperclass
@Getter @Setter
@NoArgsConstructor
public class Devices {
    //조인드, 싱글 테이블
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //테이블 퍼 클래스
    //@Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String brand;
    private int price;
}

@Entity
@Getter @Setter
@ToString
class Phone extends Devices {
    private String OS;
    private int batteryLife;
}

@Entity
@Getter @Setter
class LapTop extends Devices {
    private int RAM;
    private boolean hasTouchScreen;
}
