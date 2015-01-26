package pl.golomp.restserver.exceptions;

/**
 * Created by konrad on 26.01.15.
 */
public class BadDateException extends Exception {
    public BadDateException() {
    }

    public BadDateException(String message) {
        super(message);
    }

    public BadDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadDateException(Throwable cause) {
        super(cause);
    }

    public BadDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
