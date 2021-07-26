package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.domain.todo.BoardColor;
import com.example.potato2teambackend.domain.todo.BoardStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private String content;
    private BoardColor color;
    private BoardStatus status;

    @Builder
    public BoardUpdateRequestDto(String content, BoardColor color, BoardStatus status) {
        this.content = content;
        this.color = color;
        this.status = status;
    }

}
