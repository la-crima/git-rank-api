package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.repository.AuthRepository;
import com.mallycrip.rank.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateAuthCodeUseCaseImpl implements ValidateAuthCodeUseCase {
    private final AuthRepository authRepository;

    @Override
    public String execute(String authCode) {
        return authRepository.findByAuthCode(authCode).orElseThrow(NotFoundException::new).getEmail();
    }
}
