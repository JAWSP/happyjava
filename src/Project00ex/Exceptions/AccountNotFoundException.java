package Project00ex.Exceptions;

//너님 계좌없
public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
