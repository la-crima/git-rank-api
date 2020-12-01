package com.mallycrip.rank.exception;

public class NotFoundException extends BusinessException {
    public NotFoundException() { super("Not Found", 404); }
}
