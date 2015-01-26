package pl.golomp.restserver.exceptions;

/**
 * Created by konrad on 26.01.15.
 */
public class MessageNotReadyYetException extends Exception {
    public MessageNotReadyYetException() {
    }

    public MessageNotReadyYetException(String message) {
        super(message);
    }

    public MessageNotReadyYetException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageNotReadyYetException(Throwable cause) {
        super(cause);
    }

    public MessageNotReadyYetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
