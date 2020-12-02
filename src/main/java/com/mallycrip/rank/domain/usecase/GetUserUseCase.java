package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.dto.UserResponse;

public interface GetUserUseCase {
    public UserResponse execute(String email);
}
