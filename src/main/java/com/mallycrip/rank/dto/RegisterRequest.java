package com.mallycrip.rank.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RegisterRequest {
    @NotNull
    private String authCode;

    @NotNull
    private String password;

    @NotNull
    private String githubId;
}
