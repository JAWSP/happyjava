package Project00ex.Exceptions;

//너님 돈없
public class InvalidTransactionException extends Exception {
    public InvalidTransactionException (String message) {
        super(message);
    }
}
