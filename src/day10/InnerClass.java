package day10;

//내부 클래스는 클래스 안의 클래스가 있다고
class BallPen {
    Ball ballPenBall;
    class Ball {

    }
}

class Book {
    private String title;
    private  Author author;
    public Book(String title) {
        this.title = title;
        this.author = new Author();
    }

    public void bookTest() {
        System.out.println(title);
    }

    public class Author {
        private  String name;
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public Author getAuthor() {return this.author; }

    public void printBookDetails() {
        System.out.println("Book title :" + this.title);
        System.out.println("Author : " + getAuthor().name);
    }
}

public class InnerClass {
    public static void main(String[] args) {
        Book book = new Book("asd");
        book.getAuthor().setName("www");
    }
}
