package com.example.rest.Bean;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Pizza {
    private String size;  // (Small, Medium, Large)
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

}