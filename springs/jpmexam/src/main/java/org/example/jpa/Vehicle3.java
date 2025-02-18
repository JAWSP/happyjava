package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//테이블 퍼 클래스 전략
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter
@NoArgsConstructor
//@MappedSuperclass
public class Vehicle3 {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    private String manufacturer;
}

@Entity
@Getter @Setter
@NoArgsConstructor
class Car3 extends Vehicle3 {
    private int seatcount;
}

@Entity
@Getter @Setter
@NoArgsConstructor
class Truck3 extends Vehicle3 {
    private double payloadCapatity;
}
