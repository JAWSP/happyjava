package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class bookMain {
    public static void main(String[] args) {
        BookManager bm = new BookManager();

        Book book1 = new Book();
        Book book2 = new Book(1984, "jone doe", "asd");
        Book book3 = new Book(1999, "jane doe", "qew");
        Book book4 = new Book(1557, "CT", "why end it fast IG???");

        bm.addBook(book1);
        bm.addBook(book2);
        bm.addBook(book3);
        bm.addBook(book4);

        bm.findBook("why end it fast IG???");

        bm.removeBook(book4);

        bm.findBook(1557);

        BookManager manager = new BookManager();
        manager.addBook(new Book(2015, "강경미","모두의 자바"));
        manager.addBook(new Book(2018, "신용권", "이거이 자바다"));
        manager.addBook(new Book(2013, "남궁성", "자바의 정석"));

        List<Book> bookList = new ArrayList<>(manager.books);
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getYear(), o2.getYear());
            }
        });
        System.out.println(bookList);
    }
}
