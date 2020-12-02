package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.entity.Contributions;
import com.mallycrip.rank.dto.UserResponse;

import java.util.List;

public interface GetRankUseCase {
    public List<UserResponse> execute();
}
