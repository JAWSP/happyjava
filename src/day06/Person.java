package day06;

import java.security.PublicKey;
import java.security.SecureRandom;

public class Person {
    private  String name;
    private  String country;
    private  int age;

    public Person(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;                          ;

        System.out.println("응애");

    }

    public Person(String name) {
        this(name, "병원", 0);
    }

    public Person(String name, String country) {
        this(name, country, 0);
    }
    public Person() {
        this("응애", "병원", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person 철수 = new Person();
        Person 영희 = new Person("영희");

    }

}
