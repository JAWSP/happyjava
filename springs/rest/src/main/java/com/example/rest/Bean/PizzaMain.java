package com.example.rest.Bean;

public class PizzaMain {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("코스트코사이즈", true, true, true);

        Pizza neoNewPizza = Pizza.builder()
                .size("XXL")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(true)
                .build();
    }
}
