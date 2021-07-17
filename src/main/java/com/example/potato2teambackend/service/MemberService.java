package com.example.potato2teambackend.service;

import com.example.potato2teambackend.dto.MemberJoinRequestDto;
import com.example.potato2teambackend.dto.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public Long joinMember(MemberJoinRequestDto dto){
        return memberRepository.save(dto.toEntity(passwordEncoder)).getId();
    }

    // TODO email 중복....

}
