package day01;

import javax.print.Doc;

public class Doctest {
    /*
    title
    price를 필드로
     */
    //Doctest docTest = new Doctest();
    static private  String title;
    static private  int price;

    static public int getPrice()
    {
        return price * 2;
    }
    static public void setPrice(int price) {
        Doctest.price = price;
    }
    static public  String getName()
    {
        return title;
    }

    static public void setName(String title) { Doctest.title = title;}

    public static void main(String[] args) {
        setPrice(100);
        Doctest.setName("asd");
        System.out.print(Doctest.getName());
        System.out.print(Doctest.getPrice());
    }
}
