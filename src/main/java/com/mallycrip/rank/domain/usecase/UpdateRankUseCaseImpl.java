package com.mallycrip.rank.domain.usecase;

import com.mallycrip.rank.domain.entity.Contributions;
import com.mallycrip.rank.domain.repository.ContributionsRepository;
import com.mallycrip.rank.infra.github.GithubService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class UpdateRankUseCaseImpl implements UpdateRankUseCase {
    private final ContributionsRepository contributionsRepository;
    private final GithubService githubService;

    @Override
    @Scheduled(fixedDelay = 43200000)
    public void execute() throws IOException {
        for (Contributions contributions: contributionsRepository.findAll()) {

            contributions.updateNumOfContributions(githubService.getContributions(contributions.getGithubId()));
            contributions.updateGithubImage(githubService.getImageUrl(contributions.getGithubId()));
            contributionsRepository.save(
                    contributions
            );
        }
    }
}
