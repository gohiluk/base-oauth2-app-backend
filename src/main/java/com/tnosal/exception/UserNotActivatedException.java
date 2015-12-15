package com.tnosal.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by gohilukk on 2015-12-13.
 */
public class UserNotActivatedException extends AuthenticationException {

    public UserNotActivatedException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotActivatedException(String msg) {
        super(msg);
    }
}