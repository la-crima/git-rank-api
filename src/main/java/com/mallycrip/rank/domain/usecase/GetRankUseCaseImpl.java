package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.entity.Contributions;
import com.mallycrip.rank.domain.entity.User;
import com.mallycrip.rank.domain.repository.ContributionsRepository;
import com.mallycrip.rank.domain.repository.UserRepository;
import com.mallycrip.rank.dto.UserResponse;
import com.mallycrip.rank.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class GetRankUseCaseImpl implements GetRankUseCase {
    private final ContributionsRepository contributionsRepository;
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> execute() {
        Sort sort = sortByContributions();
        List<UserResponse> users = new ArrayList<UserResponse>();
        for (Contributions contributions: contributionsRepository.findAll(sort)) {
            User user = userRepository.findById(contributions.getEmail())
                    .orElseThrow(NotFoundException::new);

            users.add(UserResponse.builder()
                    .email(contributions.getEmail())
                    .githubId(user.getGithubId())
                    .githubImage(contributions.getGithubImage())
                    .name(user.getName())
                    .description(user.getDescription())
                    .contributions(contributions.getNumOfContributions())
                    .build());
        }

        return users;
    }

    private Sort sortByContributions() {
        return Sort.by(Sort.Direction.DESC, "numOfContributions");
    }
}
