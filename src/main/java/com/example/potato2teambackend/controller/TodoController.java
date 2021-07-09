package com.example.potato2teambackend.controller;

import com.example.potato2teambackend.dto.TodoCreateRequestDto;
import com.example.potato2teambackend.service.TodoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @ApiOperation(value="TODO 등록하기")
    @PostMapping("/api/v1/todo")
    public void requestDto(@RequestBody TodoCreateRequestDto dto) {
        todoService.save(dto);
    }

}
