package com.example.potato2teambackend.service;

import com.example.potato2teambackend.domain.member.Member;
import com.example.potato2teambackend.domain.member.MemberRepository;
import com.example.potato2teambackend.domain.todo.BoardColor;
import com.example.potato2teambackend.domain.todo.BoardStatus;
import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.domain.todo.Board;
import com.example.potato2teambackend.domain.todo.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
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

    @AfterEach
    public void cleanUp() {
        boardRepository.deleteAll();
    }

    @Test
    void 글을_저장한다() {
        // given
        Member member = Member.builder()
                .email("gochi97@naver.com")
                .name("고예림")
                .password("23234234")
                .birth(LocalDate.of(1997,02,17))
                .build();

        memberRepository.save(member);

        BoardCreateRequestDto dto = BoardCreateRequestDto.builder()
                .content("글을 저장합니다.")
                .color(BLUE)
                .build();

        // when
        boardService.save(dto, member.getId());

        // then
        Board todo = boardRepository.findAll().get(0);
        assertThat(todo.getContent()).isEqualTo(dto.getContent());
        assertThat(todo.getColor()).isEqualTo(dto.getColor());
        assertThat(todo.getMemberId()).isEqualTo(member.getId());

    }

    @Test
    void memberId와_boardId와_상태값으로_글을불러온다() {
        // given
        String content = "글을 저장해요";
        BoardColor color = BLUE;
        Long memberId = 1L;

        Board board = boardRepository.save(Board.builder()
                .content(content)
                .memberId(memberId)
                .color(color)
                .build());

        // when
        boardRepository.findByMemberIdAndIdAndStatusAndIsDeletedFalse(memberId, board.getId(), BoardStatus.TODO);

        // then
        assertThat(board.getMemberId()).isEqualTo(1L);
        assertThat(board.getId()).isEqualTo(1L);
        assertThat(board.getStatus()).isEqualTo(BoardStatus.TODO);
    }

}
