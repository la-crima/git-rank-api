package com.mallycrip.rank.exception;

public class AccountExistsException extends BusinessException {
    public AccountExistsException() { super("Account Exists", 409);}
}
