package com.mallycrip.rank.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {
    private String accessToken;
}
