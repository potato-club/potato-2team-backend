package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.dto.domain.todo.Board;
import com.example.potato2teambackend.dto.domain.todo.BoardColor;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardRetrieveAllResponseDto {

    private Long id;

    private String content;

    private BoardColor color;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dateTime;

    private boolean status;

    public BoardRetrieveAllResponseDto(Board todo) {

        this.id = todo.getId();
        this.content = todo.getContent();
        this.color = todo.getColor();
        this.dateTime = todo.getCreatedDate();
        this.status = todo.isDone();

    }

}
