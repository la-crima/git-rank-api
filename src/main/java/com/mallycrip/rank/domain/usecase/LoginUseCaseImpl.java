package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.repository.UserRepository;
import com.mallycrip.rank.dto.AuthResponse;
import com.mallycrip.rank.exception.AuthenticationFailedException;
import com.mallycrip.rank.security.JwtProvider;
import com.mallycrip.rank.util.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Override
    public AuthResponse execute(String email, String password) {
        userRepository.findById(email).ifPresent(
                user -> {
                    if (!passwordService.matches(password, user.getPassword())) throw new AuthenticationFailedException();
                }
        );
        return AuthResponse.builder().accessToken(jwtProvider.generateAccessToken(email)).build();
    }
}
