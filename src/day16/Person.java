package day16;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private int id; //주민번호
    private String name;
    private String phoneNum;
    private String address;

    public Person() {
        this.id = 0;
        this.name = "Jane doe";
        this.phoneNum = "23445";
        this.address = "everywhere";
    }

    public Person(int id, String name, String phoneNum, String address) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;

        return id == person.id && Objects.equals(name, person.name) && Objects.equals(phoneNum, person.phoneNum) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(phoneNum);
        result = 31 * result + Objects.hashCode(address);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Person o) {
        //이렇게 하면 String의 Compareable가 알아서 비교를 해준다
        return this.name.compareTo(o.name);
    }
}
