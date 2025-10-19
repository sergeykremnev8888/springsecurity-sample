package my.samples.springsecurity;

import java.util.Map;

@SuppressWarnings("serial")
public abstract class RootException extends RuntimeException {

    public RootException() { }

    public RootException(String message, Throwable cause) {
        super(message, cause);
    }

    public RootException(String message) {
        super(message);
    }

    public RootException(Throwable cause) {
        super(cause);
    }

    public RootException(String message, Throwable cause, Object ... params) {
        super(message.formatted(params), cause);
    }

    public RootException(String message, Object ... params) {
        super(message.formatted(params));
    }

    public RootException(String message, Throwable cause, Map<String, Object> params) {
        super(message.formatted(params), cause);
    }

    public RootException(String message, Map<String, Object> params) {
        super(message.formatted(params));
    }

}