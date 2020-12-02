package com.mallycrip.rank.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ChangeInfoRequest {
    @NotNull
    private String name;

    @NotNull
    private String githubId;

    @NotNull
    private String description;
}
