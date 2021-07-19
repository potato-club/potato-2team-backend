package com.example.potato2teambackend.controller;

import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.dto.BoardRetrieveAllResponseDto;
import com.example.potato2teambackend.dto.domain.todo.BoardStatus;
import com.example.potato2teambackend.service.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Configuration
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "TODO 등록하기")
    @PostMapping("/api/v1/todo")
    public ApiResponse<Long> requestDto(@Valid @RequestBody BoardCreateRequestDto dto) {
        return ApiResponse.success(boardService.save(dto));
    }

    @GetMapping("/api/v1/todo")
    public ApiResponse<List<BoardRetrieveAllResponseDto>> retrieveAllTodo(@RequestParam BoardStatus status) {
        return ApiResponse.success(boardService.retrieveAllTodo(status));
    }

}
