package com.example.potato2teambackend.service;

import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.dto.domain.todo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardCreateRequestDto dto) {
        return boardRepository.save(dto.toEntity()).getId();
    }

}
