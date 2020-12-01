package com.mallycrip.rank.service;

import com.mallycrip.rank.domain.usecase.GetAuthCodeUseCase;
import com.mallycrip.rank.domain.usecase.RegisterAccountUseCase;
import com.mallycrip.rank.domain.usecase.ValidateAuthCodeUseCase;
import com.mallycrip.rank.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {
    private final RegisterAccountUseCase registerAccountUseCase;
    private final GetAuthCodeUseCase getAuthCodeUseCase;
    private final ValidateAuthCodeUseCase validateAuthCodeUseCase;

    @Override
    public RankResponse getRank() {
        return null;
    }

    @Override
    public UserResponse getMyInfo() {
        return null;
    }

    @Override
    public UserResponse getUserInfo(GetUserInfoRequest request) {
        return null;
    }

    @Override
    public void changeInfo(ChangeInfoRequest request) {

    }

    @Override
    public void checkEmail(CheckEmailRequest request) {
        getAuthCodeUseCase.execute(request.getEmail());
    }

    @Override
    public void register(RegisterRequest request) {
        registerAccountUseCase.execute(request.getAuthCode(), request.getPassword(), request.getGithubId());
    }
}
