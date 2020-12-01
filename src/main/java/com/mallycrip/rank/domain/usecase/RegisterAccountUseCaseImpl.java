package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.entity.Auth;
import com.mallycrip.rank.domain.entity.User;
import com.mallycrip.rank.domain.repository.AuthRepository;
import com.mallycrip.rank.domain.repository.UserRepository;
import com.mallycrip.rank.exception.NotFoundException;
import com.mallycrip.rank.util.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterAccountUseCaseImpl implements RegisterAccountUseCase {
    private final PasswordService passwordService;

    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    @Override
    public void execute(String code, String password, String githubId) {
        Auth auth = authRepository.findByAuthCode(code).orElseThrow(NotFoundException::new);

        userRepository.save(
                User.builder()
                .email(auth.getEmail())
                .password(passwordService.encode(password))
                .githubId(githubId)
                .build()
        );

        authRepository.delete(auth);
    }
}
