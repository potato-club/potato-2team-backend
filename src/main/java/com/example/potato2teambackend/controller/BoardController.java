package com.example.potato2teambackend.controller;

import com.example.potato2teambackend.dto.*;
import com.example.potato2teambackend.domain.todo.BoardStatus;
import com.example.potato2teambackend.service.BoardService;
import com.example.potato2teambackend.service.TokenService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;


import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    private final TokenService tokenService;

    private static final int PAGE_NUM = 5;

    @ApiOperation(value = "TODO 등록")
    @PostMapping("/api/v1/todo")
    public ApiResponse<BoardRetrieveResponseDto> requestDto(@Valid @RequestBody BoardCreateRequestDto dto,
                                                            @RequestHeader("Authorization") String token) {
        return ApiResponse.success(boardService.save(dto, tokenService.decodeToken(token)));
    }

    @ApiOperation(value = "TODO 조회하기")
    @GetMapping("/api/v1/todo")
    public ApiResponse<List<BoardRetrieveResponseDto>> retrieveAllTodo(
            @RequestHeader("Authorization") String token,
            @RequestParam BoardStatus status
    ) {
        return ApiResponse.success(boardService.retrieveAllTodo(tokenService.decodeToken(token), status));
    }

    @ApiOperation(value = "TODO 페이지네이션")
    @GetMapping("/api/v1/todo/page")
    public ApiResponse<BoardPageResponseDto> boardDtoPage(
            @RequestParam int page,
            @RequestParam int size
    ) {
        return ApiResponse.success(boardService.pageRequest(page, size));

    }

    @ApiOperation(value = "TODO 수정하기")
    @PutMapping("/api/v1/todo/{id}")
    public ApiResponse<BoardRetrieveResponseDto> requestUpdate(@Valid @RequestBody BoardUpdateRequestDto dto,
                                                               @RequestHeader("Authorization") String token,
                                                               @PathVariable Long id) {
        Long memberId = tokenService.decodeToken(token);
        return ApiResponse.success(boardService.updateBoard(dto, memberId, id));
    }

    @ApiOperation(value = "TODO 삭제하기")
    @DeleteMapping("/api/v1/todo/{id}")
    public ApiResponse<String> deleteTodo(@Valid @RequestHeader("Authorization") String token, @PathVariable Long id) {
        boardService.deleteBoard(tokenService.decodeToken(token), id);
        return ApiResponse.OK;
    }

    @ApiOperation(value = "TODO 하나씩 조회하기")
    @GetMapping("/api/v1/todo/{id}")
    public ApiResponse<BoardRetrieveResponseDto> retrieveTodo(@Valid @RequestHeader("Authorization") String token,
                                                             @PathVariable Long id,
                                                             @RequestParam BoardStatus status) {
        Long memberId = tokenService.decodeToken(token);
        return ApiResponse.success(boardService.retrieveTodo(memberId, id, status));

    }

}
