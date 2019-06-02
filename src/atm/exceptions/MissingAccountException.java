package atm.exceptions;

public class MissingAccountException extends Exception {

    public MissingAccountException(String message) {
        super(message);
    }

    public MissingAccountException() {
    }
}
