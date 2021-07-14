package co.com.bancolombia.portal.domain.bussinesline.exception;

@SuppressWarnings("serial")
public class CleanArchitectureException extends Exception {

    public CleanArchitectureException() {
    }

    public CleanArchitectureException(String message) {
        super(message);
    }

    public CleanArchitectureException(String message, Throwable cause) {
        super(message, cause);
    }

    public CleanArchitectureException(Throwable cause) {
        super(cause);
    }
}
