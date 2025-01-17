package sample.bean;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private String title;
    private int price;

    public Book() {
        System.out.println("만들어따");
    }
}
