package com.example.potato2teambackend.service;

import com.example.potato2teambackend.domain.member.Member;
import com.example.potato2teambackend.domain.member.MemberRepository;
import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.domain.todo.Board;
import com.example.potato2teambackend.domain.todo.BoardRepository;
import com.example.potato2teambackend.dto.LoginRequestDto;
import com.example.potato2teambackend.dto.MemberJoinRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.example.potato2teambackend.domain.todo.BoardColor.BLUE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @AfterEach
    public void cleanUp() {
        boardRepository.deleteAll();
    }

    @Test
    void 글을_저장한다() {
        // given
        String name = "고예림";
        String email = "gochi97@naver.com";
        String password = "234234234";

        MemberJoinRequestDto joinRequestDto = MemberJoinRequestDto.builder()
                .birth(LocalDate.of(1997,02,17))
                .name(name)
                .password(password)
                .email(email)
                .build();

        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .email(email)
                .password(password)
                .build();

        BoardCreateRequestDto dto = BoardCreateRequestDto.builder()
                .content("글을 저장합니다.")
                .color(BLUE)
                .build();

        // when
        memberService.joinMember(joinRequestDto);
        Long memberId = memberService.loginMember(loginRequestDto);
        boardService.save(dto, memberId);

        // then
        Member member = memberRepository.findByEmail(email);
        assertThat(member.getEmail()).isEqualTo(joinRequestDto.getEmail());
        assertThat(member.getEmail()).isEqualTo(loginRequestDto.getEmail());

        Board todo = boardRepository.findAll().get(0);
        assertThat(todo.getContent()).isEqualTo(dto.getContent());
        assertThat(todo.getColor()).isEqualTo(dto.getColor());
        assertThat(todo.getMemberId()).isEqualTo(memberId);

    }

}
