package com.example.potato2teambackend.service;

import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.dto.BoardRetrieveAllResponseDto;
import com.example.potato2teambackend.dto.domain.todo.BoardRepository;
import com.example.potato2teambackend.dto.domain.todo.BoardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardCreateRequestDto dto) {
        return boardRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<BoardRetrieveAllResponseDto> retrieveAllTodo(BoardStatus status) {
        return boardRepository.findByStatusAndIsDeletedFalse(status).stream()
                .map(BoardRetrieveAllResponseDto::new)
                .collect(Collectors.toList());
    }

}
