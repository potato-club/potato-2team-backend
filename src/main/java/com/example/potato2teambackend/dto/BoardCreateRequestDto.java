package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.dto.domain.todo.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {

    @NotNull(message = "memberId를 입력해주세요.")
    private Long memberId;

    @NotBlank(message = "TODO를 입력해주세요.")
    private String todo;

    @Builder
    public BoardCreateRequestDto(String todo, Long memberId) {
        this.todo = todo;
        this.memberId = memberId;
    }

    public Board toEntity() {
        return Board.builder()
                .todo(todo)
                .memberId(memberId)
                .build();
    }
}

