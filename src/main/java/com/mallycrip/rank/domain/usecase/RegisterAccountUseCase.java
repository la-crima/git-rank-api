package com.mallycrip.rank.domain.usecase;

import java.io.IOException;

public interface RegisterAccountUseCase {
    public void execute(String code, String name, String password, String githubId);
}
