package com.mallycrip.rank.infra.github;

public interface GithubService {
    public Long getContributions(String githubId);

    public String getImageUrl(String githubId);
}
