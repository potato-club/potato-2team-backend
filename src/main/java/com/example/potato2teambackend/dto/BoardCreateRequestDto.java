package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.dto.domain.todo.Board;
import com.example.potato2teambackend.dto.domain.todo.BoardColor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {

    @NotNull(message = "memberId를 입력해주세요.")
    private Long memberId;

    @NotBlank(message = "TODO를 입력해주세요.")
    private String todo;

    @Enumerated(EnumType.STRING)
    private BoardColor color;

    @Builder
    public BoardCreateRequestDto(String todo, Long memberId, BoardColor color) {
        this.todo = todo;
        this.memberId = memberId;
        this.color = color;
    }

    public Board toEntity() {
        return Board.builder()
                .todo(todo)
                .memberId(memberId)
                .color(color)
                .build();
    }
}

