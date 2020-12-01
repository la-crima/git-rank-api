package com.mallycrip.rank.controller;

import com.mallycrip.rank.dto.*;
import com.mallycrip.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;

    public UserResponse getMyInfo() {
        return rankService.getMyInfo();
    }

    public UserResponse getUserInfo(GetUserInfoRequest request) {
        return rankService.getUserInfo(request);
    }

    @PostMapping("/account/email")
    @ResponseStatus(HttpStatus.OK)
    public void checkEmail(@RequestBody @Valid CheckEmailRequest request) {
        rankService.checkEmail(request);
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest request) {
        rankService.register(request);
    }

    public void changeInfo(ChangeInfoRequest request) {
        rankService.changeInfo(request);
    }

    public void deleteAccount() {
        // TODO
    }

    public RankResponse getRanks() {
        return rankService.getRank();
    }
}
