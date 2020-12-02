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

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@RequestBody @Valid AuthRequest request) {
        return rankService.login(request);
    }

    @GetMapping("/account/me")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getMyInfo() {
        return rankService.getMyInfo();
    }

    @GetMapping("/account")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserInfo(@RequestParam String email) {
        return rankService.getUserInfo(email);
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

    @PutMapping("/account")
    @ResponseStatus(HttpStatus.OK)
    public void changeInfo(ChangeInfoRequest request) {
        rankService.changeInfo(request);
    }

    @GetMapping("/rank")
    @ResponseStatus(HttpStatus.OK)
    public RankResponse getRanks() {
        return rankService.getRank();
    }
}
