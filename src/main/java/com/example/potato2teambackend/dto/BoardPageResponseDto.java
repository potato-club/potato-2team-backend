package com.example.potato2teambackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BoardPageResponseDto {

    private int totalPages;

    private long totalElements;

    private List<BoardDto> contents;

    @Builder
    public BoardPageResponseDto(int totalPages, long totalElements, List<BoardDto> contents) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.contents = contents;
    }

}
