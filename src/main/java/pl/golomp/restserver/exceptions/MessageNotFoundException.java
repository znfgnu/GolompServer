package pl.golomp.restserver.exceptions;

/**
 * Created by konrad on 26.01.15.
 */
public class MessageNotFoundException extends Exception {
    public MessageNotFoundException() {
    }

    public MessageNotFoundException(String message) {
        super(message);
    }

    public MessageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageNotFoundException(Throwable cause) {
        super(cause);
    }

    public MessageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
