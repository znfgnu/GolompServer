package pl.golomp.restserver.exceptions;

/**
 * Created by konrad on 26.01.15.
 */
public class NotPermittedException extends Exception {
    public NotPermittedException() {
    }

    public NotPermittedException(String message) {
        super(message);
    }

    public NotPermittedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotPermittedException(Throwable cause) {
        super(cause);
    }

    public NotPermittedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
