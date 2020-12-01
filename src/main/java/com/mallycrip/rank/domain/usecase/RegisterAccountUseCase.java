package com.mallycrip.rank.domain.usecase;

public interface RegisterAccountUseCase {
    public void execute(String code, String password, String githubId);
}
