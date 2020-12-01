package com.mallycrip.rank.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private Integer errorCode;

    public BusinessException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
