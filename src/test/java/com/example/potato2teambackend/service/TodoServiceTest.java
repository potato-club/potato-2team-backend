package com.example.potato2teambackend.service;

import com.example.potato2teambackend.dto.TodoCreateRequestDto;
import com.example.potato2teambackend.dto.domain.todo.Todo;
import com.example.potato2teambackend.dto.domain.todo.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoServiceTest {
    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @AfterEach
    public void cleanUp() {
        todoRepository.deleteAll();
    }

    @Test
    void 글을_저장한다() {
        // given
        TodoCreateRequestDto dto = TodoCreateRequestDto.builder()
                .todo("글을 저장합니다.")
                .build();

        // when
        todoService.save(dto);

        // then
        Todo todo = todoRepository.findAll().get(0);
        assertThat(todo.getTodo()).isEqualTo(dto.getTodo());
    }

}
