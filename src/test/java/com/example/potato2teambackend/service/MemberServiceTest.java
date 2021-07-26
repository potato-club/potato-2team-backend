package com.example.potato2teambackend.service;

import com.example.potato2teambackend.dto.MemberJoinRequestDto;
import com.example.potato2teambackend.domain.member.Member;
import com.example.potato2teambackend.domain.member.MemberRepository;
import com.example.potato2teambackend.exception.ConflictException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberService service;

    @Autowired
    private MemberRepository repository;

    @AfterEach
    void cleanUp() {
        repository.deleteAll();
    }

    @Test
    void 회원가입_하기() {
        // given
        LocalDate localDate = LocalDate.of(1997, 2, 17);
        String name = "고예림";
        String email = "gochi97@naver.com";
        String password = "123123123";
        MemberJoinRequestDto dto = MemberJoinRequestDto.builder()
                .name(name)
                .email(email)
                .birth(LocalDate.of(1997, 2, 17))
                .password(password)
                .build();

        // when
        service.joinMember(dto);

        // then
        Member member = repository.findAll().get(0);
        assertThat(member.getBirth()).isEqualTo(localDate);
    }

    @Test
    void 기존의_이메일이_있으면_에러가_넘어올까요() {
        // given
        String email = "yerimkoko@gmail.com";
        String name = "고예림";
        String password = "12312312312";
        LocalDate birth = LocalDate.of(1997,02,17);
        repository.save(Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .birth(birth)
                .build());

        MemberJoinRequestDto requestDto = MemberJoinRequestDto.builder()
                .email(email)
                .name(name)
                .password(password)
                .birth(birth)
                .build();

        // when
        assertThatThrownBy(() -> service.joinMember(requestDto)).isInstanceOf(ConflictException.class);
    }

}
