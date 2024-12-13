package day10;

import java.util.SortedMap;

public class Obex {
    public static void main(String[] args) {
        Obex obex = new Obex();
        //getclass는 오버라이딩 하지 않아도 클래스명과 패키지명?도 준다
        System.out.println(obex.getClass());

        String str1 = "Java";
        String str2 = "JAVA";

        System.out.println(str1.equals(str2));
        //얜 대소문자 구별 안하는 equals
        System.out.println(str1.equalsIgnoreCase(str2));

        String str = "hi";
        //얜 +과 같은 역할
        str = str.concat(" hahahahaha");
        System.out.println(str);

        StringBuilder builder = new StringBuilder(str);
        builder.append("!!!!");
        System.out.println(builder.toString());
        builder.delete(3, 6);
        System.out.println(builder.toString());
        builder.reverse();
        System.out.println(builder.toString());


    }
}
