package com.mallycrip.rank.exception;

public class InvalidTokenException extends BusinessException {
    public InvalidTokenException() { super("Token is Invalid", 403); }
}
