package exceptions;

public class DureeExcessiveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DureeExcessiveException(String message) {
        super(message);
    }

}
