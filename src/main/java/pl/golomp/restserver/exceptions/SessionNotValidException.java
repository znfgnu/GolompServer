package pl.golomp.restserver.exceptions;

/**
 * Created by konrad on 26.01.15.
 */
public class SessionNotValidException extends Exception {
    public SessionNotValidException() {
    }

    public SessionNotValidException(String message) {
        super(message);
    }

    public SessionNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionNotValidException(Throwable cause) {
        super(cause);
    }

    public SessionNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
