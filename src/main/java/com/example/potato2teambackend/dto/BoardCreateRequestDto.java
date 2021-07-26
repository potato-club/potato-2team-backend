package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.domain.todo.Board;
import com.example.potato2teambackend.domain.todo.BoardColor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {

    @NotBlank(message = "TODO를 입력해주세요.")
    private String content;

    @Enumerated(EnumType.STRING)
    private BoardColor color;

    @Builder
    public BoardCreateRequestDto(String content, BoardColor color) {
        this.content = content;
        this.color = color;
    }

    public Board toEntity(Long memberId) {
        return Board.builder()
                .content(content)
                .color(color)
                .memberId(memberId)
                .build();
    }

}

