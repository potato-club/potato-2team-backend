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

    public Long joinMember(MemberJoinRequestDto dto) {
        if (memberRepository.findByEmail(dto.getEmail()) != null) {
            throw new IllegalArgumentException("해당하는 이메일이 존재합니다!");
        }
        return memberRepository.save(dto.toEntity(passwordEncoder)).getId();
    }

}
