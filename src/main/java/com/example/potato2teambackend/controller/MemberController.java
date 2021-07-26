package com.example.potato2teambackend.controller;

import com.example.potato2teambackend.dto.LoginRequestDto;
import com.example.potato2teambackend.dto.MemberInfoResponseDto;
import com.example.potato2teambackend.dto.MemberJoinRequestDto;
import com.example.potato2teambackend.service.MemberService;
import com.example.potato2teambackend.service.TokenService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "로그인")
    @PostMapping("/api/v1/login")
    public ApiResponse<String> login(@Valid @RequestBody LoginRequestDto dto) {
        return ApiResponse.success(tokenService.createToken(memberService.loginMember(dto)));
    }

    @ApiOperation(value = "멤버 정보 조회")
    @GetMapping("/api/v1/info")
    public ApiResponse<MemberInfoResponseDto> memberInfo(@Valid @RequestHeader(value = "Authorization") String token) {
        return ApiResponse.success(memberService.responseDto(tokenService.decodeToken(token)));
    }
}