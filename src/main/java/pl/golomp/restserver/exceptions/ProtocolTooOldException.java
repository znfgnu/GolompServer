package pl.golomp.restserver.exceptions;

/**
 * Created by konrad on 25.01.15.
 */
public class ProtocolTooOldException extends Exception {
    public ProtocolTooOldException() {
    }

    public ProtocolTooOldException(String message) {
        super(message);
    }

    public ProtocolTooOldException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProtocolTooOldException(Throwable cause) {
        super(cause);
    }

    public ProtocolTooOldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
