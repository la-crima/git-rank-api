package com.mallycrip.rank.domain.usecase;

public interface UpdateProfileUseCase {
    public void execute(String email, String name, String description, String githubId);
}
