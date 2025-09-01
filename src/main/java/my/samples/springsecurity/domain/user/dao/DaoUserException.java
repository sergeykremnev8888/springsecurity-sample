package my.samples.springsecurity.domain.user.dao;

import my.samples.springsecurity.OwnException;

@SuppressWarnings("serial")
public class DaoUserException extends OwnException {

    public DaoUserException() { }

    public DaoUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoUserException(String message) {
        super(message);
    }

    public DaoUserException(Throwable cause) {
        super(cause);
    }

    public DaoUserException(String message, Throwable cause, Object ... params) {
        super(message, cause, params);
    }

    public DaoUserException(String message, Object ... params) {
        super(message, params);
    }
}