package com.mallycrip.rank.exception;

public class AuthenticationFailedException extends BusinessException {
    public AuthenticationFailedException() { super("Wrong Information", 403); }
}
