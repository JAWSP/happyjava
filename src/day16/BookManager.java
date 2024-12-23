package day16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class BookManager {
    //책들을 관리하는 양반
    HashSet<Book> books = new HashSet<>();

    //책을 추가
    public void addBook(Book book) {
        books.add(book);
    }

    //책을 삭제
    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    //책 정보를 보여줌
    public void showBook(Book book) {
        System.out.println(book);
    }

    //책을 조회
    //public Book findBook(int code, String )
    //제목
    public Book findBook(String titleFor) {
        if (titleFor == null)
                return null;
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book tmp = bookIterator.next();
            if (tmp.getTitle().equals(titleFor)) {
                showBook(tmp);
                return tmp;
            }
        }
        /*
        for (Book b : books) {
            if (b.getTitle().equals(titleFor)) {
                showBook(b);
                return b;
            }
        }
         */
        System.out.println("제목 그거 맞음? ㄹㅇ?");
        return null;
    }
    //지은이
    public Book findBookAuthor(String authorFor) {
        if (authorFor == null)
            return null;
        for (Book b : books) {
            if (b.getAuthor().equals(authorFor)) {
                showBook(b);
                return b;
            }
        }
        System.out.println("네가 찾던 지은이 없는뎁쇼");
        return null;
    }

    //출판년도
    public Book findBook(int yearFor) {

        for (Book b : books) {
            if (b.getYear() == yearFor) {
                showBook(b);
                return b;
            }
        }
        System.out.println("거 출판년도를 좀 확인해보시라우");
        return null;
    }

}
