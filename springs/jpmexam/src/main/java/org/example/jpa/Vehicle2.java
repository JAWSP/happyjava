package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//조인 상속 매핑 전략
//얜 각각 매핑될것이기 떄문에 구분자가 필요없다
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@NoArgsConstructor
public class Vehicle2 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String manufacturer;
}

@Entity
@Getter @Setter
@NoArgsConstructor
class Car2 extends Vehicle2 {
    private int seatcount;
}

@Entity
@Getter @Setter
@NoArgsConstructor
class Truck2 extends Vehicle2 {
    private double payloadCapatity;
}