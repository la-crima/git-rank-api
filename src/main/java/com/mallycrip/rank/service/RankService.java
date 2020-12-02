package com.mallycrip.rank.service;

import com.mallycrip.rank.dto.*;

public interface RankService {
    public AuthResponse login(AuthRequest request);

    public UserResponse getMyInfo();

    public UserResponse getUserInfo(String email);

    public void checkEmail(CheckEmailRequest request);

    public void register(RegisterRequest request);

    public void changeInfo(ChangeInfoRequest request);

    public RankResponse getRank();
}
