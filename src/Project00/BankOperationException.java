package Project00;

//일반적인 은행 오류
public class BankOperationException extends Exception {
    public BankOperationException(String message) {
        super(message);
    }
}
