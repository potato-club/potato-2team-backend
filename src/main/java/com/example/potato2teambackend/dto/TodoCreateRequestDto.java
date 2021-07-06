package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.dto.domain.todo.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoCreateRequestDto {
    private String todo;

    @Builder
    public TodoCreateRequestDto(String todo) {
        this.todo = todo;
    }

    public Todo toEntity() {
        return Todo.builder()
                .todo(todo)
                .build();
    }
}

