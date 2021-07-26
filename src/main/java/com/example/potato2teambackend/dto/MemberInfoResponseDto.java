package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberInfoResponseDto {

    private final String email;

    private final String name;

    private final LocalDate birth;

    @Builder
    public MemberInfoResponseDto(Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
        this.birth = member.getBirth();
    }

}
