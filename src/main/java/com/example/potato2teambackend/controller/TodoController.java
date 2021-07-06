package com.example.potato2teambackend.controller;

import com.example.potato2teambackend.dto.TodoCreateRequestDto;
import com.example.potato2teambackend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/api/v1/todo")
    public void requestDto(@RequestBody TodoCreateRequestDto dto) {
        todoService.save(dto);
    }

}
