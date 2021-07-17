package com.example.potato2teambackend.controller;

import com.example.potato2teambackend.dto.MemberJoinRequestDto;
import com.example.potato2teambackend.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Getter
@RequiredArgsConstructor
@RestController
public class MemberController{

    private final MemberService memberService;

    @ApiOperation(value = "회원가입")
    @PostMapping("/api/v1/join")
    public ApiResponse<Long> requestDto(@Valid @RequestBody MemberJoinRequestDto dto) {
        return ApiResponse.success(memberService.joinMember(dto));
    }

}
