package org.example.jpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("TRUCK")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Truck extends Vehicle {
    private double payloadCapacity;
}
