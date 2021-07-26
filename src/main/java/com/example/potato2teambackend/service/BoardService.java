package com.example.potato2teambackend.service;

import com.example.potato2teambackend.domain.todo.Board;
import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import com.example.potato2teambackend.dto.BoardRetrieveResponseDto;
import com.example.potato2teambackend.domain.todo.BoardRepository;
import com.example.potato2teambackend.domain.todo.BoardStatus;
import com.example.potato2teambackend.dto.BoardUpdateRequestDto;
import com.example.potato2teambackend.exception.NotFoundException;
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
    public BoardRetrieveResponseDto save(BoardCreateRequestDto dto, Long memberId) {
        return new BoardRetrieveResponseDto(boardRepository.save(dto.toEntity(memberId)));
    }

    @Transactional(readOnly = true)
    public List<BoardRetrieveResponseDto> retrieveAllTodo(Long memberId, BoardStatus status) {
        return boardRepository.findByMemberIdAndStatusAndIsDeletedFalse(memberId, status).stream()
                .map(BoardRetrieveResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public BoardRetrieveResponseDto updateBoard(BoardUpdateRequestDto dto, Long id, Long memberId) {
        Board findBoard = boardRepository.findByMemberIdAndId(memberId, id);
        if (findBoard == null) {
            throw new NotFoundException("해당하는 todo가 존재하지 않습니다.");
        }
        findBoard.update(dto.getContent(), dto.getColor(), dto.getStatus());
        return new BoardRetrieveResponseDto(findBoard);
    }

    @Transactional
    public void deleteBoard(Long memberId, Long id) {
        Board board = boardRepository.findByMemberIdAndId(memberId, id);
        if (board == null) {
            throw new NotFoundException(String.format("해당하는 투두(%s)가 존재하지 않습니다", id));
        }
        board.delete();
    }

}