package com.example.springmvc;

//롬북은 기본적인 메소드들을 자동으로 만들어 주는 놈
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class boktest {
    public int value;
    public static void main(String[] args) {
        boktest b = new boktest();
        b.setValue(22);
        System.out.println(b.getValue());
    }
}
