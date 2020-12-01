package com.mallycrip.rank.handler.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;

    private String message;
}
