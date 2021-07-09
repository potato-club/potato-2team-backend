package com.example.potato2teambackend.service;

import com.example.potato2teambackend.dto.TodoCreateRequestDto;
import com.example.potato2teambackend.dto.domain.todo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public Long save(TodoCreateRequestDto dto) {
        return todoRepository.save(dto.toEntity()).getId();
    }

}
