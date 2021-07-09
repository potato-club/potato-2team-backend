package com.example.potato2teambackend.service;

import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.dto.domain.todo.Board;
import com.example.potato2teambackend.dto.domain.todo.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        BoardCreateRequestDto dto = BoardCreateRequestDto.builder()
                .todo("글을 저장합니다.")
                .memberId(1L)
                .build();

        // when
        boardService.save(dto);

        // then
        Board todo = boardRepository.findAll().get(0);
        assertThat(todo.getTodo()).isEqualTo(dto.getTodo());
    }

}
