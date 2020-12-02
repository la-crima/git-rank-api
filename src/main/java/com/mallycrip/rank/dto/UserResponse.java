package com.mallycrip.rank.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private String email;

    private String githubId;

    private String githubImage;

    private String name;

    private String description;

    private Long contributions;
}
