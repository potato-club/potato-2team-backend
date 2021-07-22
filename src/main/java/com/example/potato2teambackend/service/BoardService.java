package com.example.potato2teambackend.service;

import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.dto.BoardRetrieveResponseDto;
import com.example.potato2teambackend.domain.todo.BoardRepository;
import com.example.potato2teambackend.domain.todo.BoardStatus;
import com.example.potato2teambackend.dto.DtoAndMemberIdToEntity;
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
    public BoardRetrieveResponseDto save(BoardCreateRequestDto dto) {
        return new BoardRetrieveResponseDto(boardRepository.save(dto.toEntity()));
    }

    @Transactional
    public Long boardSave(BoardCreateRequestDto dto, Long memberId) {
        DtoAndMemberIdToEntity dtoAndMemberIdToEntity = new DtoAndMemberIdToEntity(dto, memberId);
        boardRepository.save(dtoAndMemberIdToEntity.toEntity());
        return memberId;

    }

    @Transactional(readOnly = true)
    public List<BoardRetrieveResponseDto> retrieveAllTodo(Long memberId, BoardStatus status) {
        return boardRepository.findByMemberIdAndStatusAndIsDeletedFalse(memberId, status).stream()
                .map(BoardRetrieveResponseDto::new)
                .collect(Collectors.toList());
    }

}
