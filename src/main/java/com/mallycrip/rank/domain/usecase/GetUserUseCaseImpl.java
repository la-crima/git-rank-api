package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.entity.Contributions;
import com.mallycrip.rank.domain.entity.User;
import com.mallycrip.rank.domain.repository.ContributionsRepository;
import com.mallycrip.rank.domain.repository.UserRepository;
import com.mallycrip.rank.dto.UserResponse;
import com.mallycrip.rank.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {
    private final UserRepository userRepository;
    private final ContributionsRepository contributionsRepository;

    @Override
    public UserResponse execute(String email) {
        User user = userRepository.findById(email).orElseThrow(NotFoundException::new);
        Contributions contributions = contributionsRepository.findById(email).orElseThrow(NotFoundException::new);

        return UserResponse.builder()
                .email(user.getEmail())
                .description(user.getDescription())
                .githubImage(contributions.getGithubImage())
                .name(user.getName())
                .githubId(user.getGithubId())
                .contributions(contributions.getNumOfContributions())
                .build();
    }
}
