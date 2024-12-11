package day08;

//예기치 못한 일을 만났을때 컴퓨럴은 예외를 만나고 에러를 뱉게 된다
public class YeWay {
    public static void main(String[] args) {
        try {
            System.out.println(args[0]);
            //Exception은 자바 내에 있던 예외처리 클래스인가벼
        } catch(Exception e) {
            System.out.println("적절한 예외처리");
        }
        System.out.println("next");
        int [] iarr = {1, 2, 3};
        try {
            System.out.println(iarr[2]);
        }catch (ArithmeticException e) {
            System.out.println("eee");
            //산술 예외
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Err");
        } catch (Exception e) {
            System.out.println("아무튼 에러래요");
        } finally {
            System.out.println("와 이게 되네");
        }

    }
}
