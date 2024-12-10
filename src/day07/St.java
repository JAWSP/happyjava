package day07;

import java.util.SortedMap;

public class St {

    public static boolean find(String str, char findchar) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == findchar)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = new String("hello");
        String str4 = "hello";

        System.out.println(str1 == str2); //f
        System.out.println(str1 == str4); //t
        System.out.println(str2 == str3); //f

        String str5 = str1;
        str5 = "asd";

        System.out.println(str1);

        System.out.println(str1.charAt(2));
        System.out.println(find(str1, 'a'));

    }
}
