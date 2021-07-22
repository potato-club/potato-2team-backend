package com.example.potato2teambackend.dto;

import com.example.potato2teambackend.domain.todo.Board;
import com.example.potato2teambackend.domain.todo.BoardColor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DtoAndMemberIdToEntity {
    private String content;
    private BoardColor color;
    private Long memberId;

    @Builder
    public DtoAndMemberIdToEntity(BoardCreateRequestDto dto, Long memberId) {

        this.content = dto.getContent();
        this.color = dto.getColor();
        this.memberId = memberId;

    }

    public Board toEntity() {
        return Board.builder()
                .content(getContent())
                .color(getColor())
                .memberId(memberId)
                .build();
    }
}
