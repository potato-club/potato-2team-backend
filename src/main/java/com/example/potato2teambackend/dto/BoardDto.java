package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.domain.todo.Board;
import com.example.potato2teambackend.domain.todo.BoardColor;
import com.example.potato2teambackend.domain.todo.BoardStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardDto {

    private Long id;

    private String content;

    private BoardColor color;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dateTime;

    private BoardStatus status;

    private boolean isDeleted;

    private Long memberId;

    private BoardDto(Board todo) {
        this.id = todo.getId();
        this.memberId = todo.getMemberId();
        this.content = todo.getContent();
        this.color = todo.getColor();
        this.dateTime = todo.getCreatedDate();
        this.status = todo.getStatus();
        this.isDeleted = todo.isDeleted();
    }

    public static BoardDto of(Board board) {
        return new BoardDto(board);
    }

}
