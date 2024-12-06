package day05;

public class Output {

    //1개는 얘가 출력
    void 뱉(int i) {
        System.out.print("정수 출력 : ");
        System.out.println(i);
    }

    //2개 이상은 얘가 출력
    void  뱉 (int... is) {
        System.out.print("정수 여려개 출력 : ");
        for (int i : is) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void 뱉(String s) {
        System.out.print("문자열 출력 : ");
        System.out.println(s);
    }

    void 뱉(float f) {
        System.out.print("실수 출력 : ");
        System.out.println(f);
    }

    public static void main(String[] args) {
        Output output = new Output();

        output.뱉(21);
        output.뱉("ssss");
        output.뱉(3.123f);
        output.뱉(1, 2, 3, 4, 5, 6,7);
    }
}
