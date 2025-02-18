package org.example.jpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("CAR")
@ToString
public class Car extends Vehicle {
    private int seatCount;
}
