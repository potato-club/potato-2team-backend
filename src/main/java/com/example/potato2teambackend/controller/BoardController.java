package com.example.potato2teambackend.controller;

import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.dto.BoardRetrieveResponseDto;
import com.example.potato2teambackend.domain.todo.BoardStatus;
import com.example.potato2teambackend.service.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "TODO 등록하기")
    @PostMapping("/api/v1/todo")
    public ApiResponse<BoardRetrieveResponseDto> requestDto(@Valid @RequestBody BoardCreateRequestDto dto) {
        return ApiResponse.success(boardService.save(dto));
    }

    @ApiOperation(value = "TODO 조회하기")
    @GetMapping("/api/v1/todo")
    public ApiResponse<List<BoardRetrieveResponseDto>> retrieveAllTodo(
            @RequestParam Long memberId,
            @RequestParam BoardStatus status
    ) {
        return ApiResponse.success(boardService.retrieveAllTodo(memberId, status));
    }

}
