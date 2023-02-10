package exceptions;

public class MontantExcessifException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MontantExcessifException(String message) {
        super(message);
    }

}
