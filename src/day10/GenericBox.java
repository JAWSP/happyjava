package day10;

//T는 가상의 타입 -> 아무거나 넣어도 됨
//귀에 걸면 귀걸이 코에 걸면 코걸이
//템플릿 맞네
public class GenericBox<T> {

    T Item;

    public T getItem() {
        return Item;
    }

    public void setItem(T item) {
        Item = item;
    }

    public static void main(String[] args) {

        //만약에 String타입을 쓰고 싶다면 이렇게
        GenericBox<String> genericBox = new GenericBox<String>();
        genericBox.setItem("ASD");
        System.out.println(genericBox.getItem().toUpperCase());

        //싫다 나는 다른 객체를타입으로 쓰고 싶다면 저렇게
        GenericBox<Book> bookGenericBox = new GenericBox<Book>();
        bookGenericBox.setItem(new Book("wwwww"));
        bookGenericBox.getItem().bookTest();
    }
}
