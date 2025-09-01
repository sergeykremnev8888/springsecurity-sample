package my.samples.springsecurity;

import java.util.Map;

@SuppressWarnings("serial")
public abstract class OwnException extends RuntimeException {

    public OwnException() { }

    public OwnException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnException(String message) {
        super(message);
    }

    public OwnException(Throwable cause) {
        super(cause);
    }

    public OwnException(String message, Throwable cause, Object ... params) {
        super(message.formatted(params), cause);
    }

    public OwnException(String message, Object ... params) {
        super(message.formatted(params));
    }

    public OwnException(String message, Throwable cause, Map<String, Object> params) {
        super(message.formatted(params), cause);
    }

    public OwnException(String message, Map<String, Object> params) {
        super(message.formatted(params));
    }

}