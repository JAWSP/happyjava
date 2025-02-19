package com.example.springdatajpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Table(name = "jpa_order")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Order(String product, LocalDateTime date, Customer customer) {
        this.product = product;
        this.date = date;
        this.customer = customer;
    }
}
