package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.entity.Auth;
import com.mallycrip.rank.domain.entity.Contributions;
import com.mallycrip.rank.domain.entity.User;
import com.mallycrip.rank.domain.repository.AuthRepository;
import com.mallycrip.rank.domain.repository.ContributionsRepository;
import com.mallycrip.rank.domain.repository.UserRepository;
import com.mallycrip.rank.exception.NotFoundException;
import com.mallycrip.rank.infra.github.GithubService;
import com.mallycrip.rank.util.PasswordService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class RegisterAccountUseCaseImpl implements RegisterAccountUseCase {
    private final PasswordService passwordService;

    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final ContributionsRepository contributionsRepository;
    private final GithubService githubService;

    @Override
    public void execute(String code, String name, String password, String githubId) {
        Auth auth = authRepository.findByAuthCode(code).orElseThrow(NotFoundException::new);

        userRepository.save(
                User.builder()
                .email(auth.getEmail())
                .name(name)
                .password(passwordService.encode(password))
                .githubId(githubId)
                .build()
        );

        authRepository.delete(auth);

        contributionsRepository.save(
                Contributions.builder()
                        .email(auth.getEmail())
                        .numOfContributions(githubService.getContributions(githubId))
                        .githubId(githubId)
                        .build()
        );
    }
}
