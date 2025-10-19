package my.samples.springsecurity.web;

import my.samples.springsecurity.RootException;

@SuppressWarnings("serial")
public class WebException extends RootException {

    public WebException() {
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebException(String message) {
        super(message);
    }

    public WebException(Throwable cause) {
        super(cause);
    }

    public WebException(String message, Throwable cause, Object... params) {
        super(message, cause, params);
    }

    public WebException(String message, Object... params) {
        super(message, params);
    }
}
