package my.samples.springsecurity.domain.user;

import my.samples.springsecurity.RootException;

@SuppressWarnings("serial")
public class UserException extends RootException {

    public UserException() { }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause, Object ... params) {
        super(message, cause, params);
    }

    public UserException(String message, Object ... params) {
        super(message, params);
    }
}