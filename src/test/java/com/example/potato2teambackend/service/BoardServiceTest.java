package com.example.potato2teambackend.service;

import com.example.potato2teambackend.domain.member.Member;
import com.example.potato2teambackend.domain.member.MemberRepository;
import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.domain.todo.Board;
import com.example.potato2teambackend.domain.todo.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static com.example.potato2teambackend.domain.todo.BoardColor.BLUE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @AfterEach
    public void cleanUp() {
        boardRepository.deleteAll();
    }

    @Test
    void 글을_저장한다() {
        // given
        Member member = Member.builder().build();

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

}
