package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.dto.domain.todo.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class TodoCreateRequestDto {

    @NotNull(message = "memberId를 입력해주세요.")
    private Long memberId;

    @NotBlank(message = "TODO를 입력해주세요.")
    private String todo;

    @Builder
    public TodoCreateRequestDto(String todo, Long memberId) {
        this.todo = todo;
        this.memberId = memberId;
    }

    public Todo toEntity() {
        return Todo.builder()
                .todo(todo)
                .memberId(memberId)
                .build();
    }
}

