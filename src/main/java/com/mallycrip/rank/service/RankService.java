package com.mallycrip.rank.service;

import com.mallycrip.rank.dto.*;

public interface RankService {
    public UserResponse getMyInfo();

    public UserResponse getUserInfo(GetUserInfoRequest request);

    public void checkEmail(CheckEmailRequest request);

    public void register(RegisterRequest request);

    public void changeInfo(ChangeInfoRequest request);

    public RankResponse getRank();
}
