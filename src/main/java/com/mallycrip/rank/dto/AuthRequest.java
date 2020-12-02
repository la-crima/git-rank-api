package com.mallycrip.rank.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class AuthRequest {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
