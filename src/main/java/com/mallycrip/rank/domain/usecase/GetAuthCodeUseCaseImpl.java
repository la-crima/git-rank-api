package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.entity.Auth;
import com.mallycrip.rank.domain.repository.AuthRepository;
import com.mallycrip.rank.domain.repository.UserRepository;
import com.mallycrip.rank.exception.AccountExistsException;
import com.mallycrip.rank.exception.NoSchoolEmailException;
import com.mallycrip.rank.infra.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetAuthCodeUseCaseImpl implements GetAuthCodeUseCase {
    private final EmailService emailService;

    private final UserRepository userRepository;
    private final AuthRepository authRepository;

    @Override
    public void execute(String email) {
        if (userRepository.findById(email).isPresent()) throw new AccountExistsException();
        String code = UUID.randomUUID().toString();

        if (!email.contains("@dsm.hs.kr")) throw new NoSchoolEmailException();

        authRepository.save(Auth.builder()
                .email(email)
                .authCode(code)
                .build());

        emailService.sendEmail(email, "DSM Github Rank 인증 코드 입니다.", code);
    }
}
