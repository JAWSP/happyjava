package day08;

public class Question2 {

    public static int q1(int a, int b) {
        int result = 0;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        return result;

    }

    public static int q2(int[] arr, int i) {
        int result = 0;
        try {
            result = arr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 범위를 확인하세요!");
        }
        return result;
    }


    public static int q3(String str) {
        int result = 0;
        try {
            result = str.length();
        } catch (NullPointerException e) {
            System.out.println("문자열이 null 상태입니다.");
        }
        return result;
    }
    public static void main(String[] args) {
        int a = 50;
        int b = 0;
        System.out.println(q1(a, b));

        int arr[] = {10, 20, 30};

        System.out.println(q2(arr, 40));

        String str = null;

        System.out.println(q3(str));

        String numStr = "123a";

        try {
            Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값은 정수로 변환할 수 없습니다.");
        }

    }
}
