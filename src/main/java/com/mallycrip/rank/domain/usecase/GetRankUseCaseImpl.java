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

import java.util.*;


@Component
@RequiredArgsConstructor
public class GetRankUseCaseImpl implements GetRankUseCase {
    private final ContributionsRepository contributionsRepository;
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> execute() {
        List<UserResponse> users = new ArrayList<UserResponse>();
        for (Contributions contributions: sortContributions(contributionsRepository.findAll())) {
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

    private Iterable<Contributions> sortContributions(Iterable<Contributions> contributions) {
        List<Contributions> sortedContributions = new ArrayList<>();
        for (Contributions contribution: contributions) {
            sortedContributions.add(contribution);
        }
        sortedContributions.sort(Comparator.comparing(Contributions::getNumOfContributions).reversed());
        return sortedContributions;
    }
}
