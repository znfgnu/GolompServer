package pl.golomp.restserver.exceptions;

/**
 * Created by konrad on 25.01.15.
 */
public class SampleException extends Exception {
    public SampleException() {
    }

    public SampleException(String message) {
        super(message);
    }

    public SampleException(String message, Throwable cause) {
        super(message, cause);
    }

    public SampleException(Throwable cause) {
        super(cause);
    }

    public SampleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
