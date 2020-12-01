package com.mallycrip.rank.dto;

import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class CheckEmailRequest {
    @Email
    private String email;
}
