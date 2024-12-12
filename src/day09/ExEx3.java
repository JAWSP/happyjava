package day09;

//메서드가 실행되는 에 예외가 발생할 수 있다
public class ExEx3  {
    public static void Rm() throws RuntimeException {
        //예외가 발생할 때 호출한 쪽에서 예외처리를 맡기는 경우(런타임)
    }

    public static void Cm() throws Exception {
        //예외가 발생할 때 호출한 쪽에서 예외처리를 맡기는 경우 (체크드)
    }

    public static void CC() {
        //예외가 발생할때 그냥 메소드 내에서 처리하는 경우

        try {
            Cm();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Rm(); //런타임은 그냥 던져도 되는데
        try {
            Cm(); //채크드는 반드시 예외처리를 시행해야 한다
        } catch (Exception e) {
            System.out.println(e);
        }

        CC();
    }
}
