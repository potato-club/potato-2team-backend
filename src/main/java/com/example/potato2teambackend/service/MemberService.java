package com.example.potato2teambackend.service;

import com.example.potato2teambackend.domain.member.Member;
import com.example.potato2teambackend.dto.LoginRequestDto;
import com.example.potato2teambackend.dto.MemberInfoResponseDto;
import com.example.potato2teambackend.dto.MemberJoinRequestDto;
import com.example.potato2teambackend.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional
    public Long joinMember(MemberJoinRequestDto dto) {
        if (memberRepository.findByEmail(dto.getEmail()) != null) {
            throw new IllegalArgumentException("해당하는 이메일이 존재합니다!");
        }
        return memberRepository.save(dto.toEntity(passwordEncoder)).getId();
    }

    @Transactional
    public Long loginMember(LoginRequestDto requestDto) {
        Member member = memberRepository.findByEmail(requestDto.getEmail());
        if (member == null) {
            throw new IllegalArgumentException("일치하는 이메일이 없습니다.");
        }

        if (!passwordEncoder.matches(requestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        }
        return member.getId();
    }

    @Transactional(readOnly = true)
    public MemberInfoResponseDto responseDto(Long memberId) {
        Member member = memberRepository.findByIdAndIsDeletedIsFalse(memberId);
        if( member == null) {
            throw new IllegalArgumentException("다시 로그인해주세요!");
        }

        return new MemberInfoResponseDto(member);
    }

}
