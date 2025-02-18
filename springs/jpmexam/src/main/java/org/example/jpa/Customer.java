package org.example.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Embedded
    private ContactInfo contactInfo;

    public Customer(String name, ContactInfo contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }
}

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class ContactInfo{
    private String email;
    private String phoneNum;
}
