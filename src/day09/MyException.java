package day09;


public class MyException extends Exception {
    public MyException() {
        super("custom exception");
    }

    public MyException(String msg) {
        super(msg);
        //이렇게 메세지를 넣으면 Exception.getMessage에서 저게 출력이 된다고
    }
}
