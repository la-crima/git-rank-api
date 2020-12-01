package com.mallycrip.rank.exception;

public class NoSchoolEmailException extends BusinessException{
    public NoSchoolEmailException() { super("Use a School Email", 403); }
}
