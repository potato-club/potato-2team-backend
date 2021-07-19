package com.example.potato2teambackend.controller;

import com.example.potato2teambackend.dto.LoginRequestDto;
import com.example.potato2teambackend.dto.MemberJoinRequestDto;
import com.example.potato2teambackend.service.MemberService;
import com.example.potato2teambackend.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberController{

    private final MemberService memberService;
    private final TokenService tokenService;

    @ApiOperation(value = "회원가입")
    @PostMapping("/api/v1/join")
    public ApiResponse<Long> signUp(@Valid @RequestBody MemberJoinRequestDto dto) {
        return ApiResponse.success(memberService.joinMember(dto));
    }

    @PostMapping("/api/v1/login")
    public ApiResponse<String> login(@Valid @RequestBody LoginRequestDto dto) {
        return ApiResponse.success(tokenService.createToken(memberService.loginMember(dto)));
    }

}
