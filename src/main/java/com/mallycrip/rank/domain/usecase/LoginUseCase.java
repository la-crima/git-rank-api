package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.dto.AuthResponse;

public interface LoginUseCase {
    public AuthResponse execute(String email, String password);
}
