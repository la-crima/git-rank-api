package com.mallycrip.rank.service;

import com.mallycrip.rank.domain.usecase.*;
import com.mallycrip.rank.dto.*;
import com.mallycrip.rank.exception.NotFoundException;
import com.mallycrip.rank.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {
    private final AuthenticationFacade authenticationFacade;

    private final GetUserUseCase getUserUseCase;
    private final RegisterAccountUseCase registerAccountUseCase;
    private final GetAuthCodeUseCase getAuthCodeUseCase;
    private final GetRankUseCase getRankUseCase;
    private final ValidateAuthCodeUseCase validateAuthCodeUseCase;
    private final UpdateRankUseCase updateRankUseCase;
    private final UpdateProfileUseCase updateProfileUseCase;
    private final LoginUseCase loginUseCase;

    @Override
    public AuthResponse login(AuthRequest request) {
        return loginUseCase.execute(request.getEmail(), request.getPassword());
    }

    @Override
    public RankResponse getRank() {
        return RankResponse.builder()
                .rank(getRankUseCase.execute())
                .build();
    }

    @Override
    public UserResponse getMyInfo() {
        return getUserUseCase.execute(authenticationFacade.getEmail());
    }

    @Override
    public UserResponse getUserInfo(String email) {
        return getUserUseCase.execute(email);
    }

    @Override
    public void changeInfo(ChangeInfoRequest request) {
        updateProfileUseCase.execute(
                authenticationFacade.getEmail(),
                request.getName(),
                request.getDescription(),
                request.getGithubId()
        );
    }

    @Override
    public void checkEmail(CheckEmailRequest request) {
        getAuthCodeUseCase.execute(request.getEmail());
    }

    @Override
    public void register(RegisterRequest request) {
        registerAccountUseCase.execute(
                request.getAuthCode(), request.getName(), request.getPassword(), request.getGithubId());
    }
}
