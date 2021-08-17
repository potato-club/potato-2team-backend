package com.example.potato2teambackend.service;

import com.example.potato2teambackend.domain.todo.Board;
import com.example.potato2teambackend.dto.*;
import com.example.potato2teambackend.domain.todo.BoardRepository;
import com.example.potato2teambackend.domain.todo.BoardStatus;
import com.example.potato2teambackend.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Transactional(readOnly = true) // TODO 조회하기
    public List<BoardRetrieveResponseDto> retrieveAllTodo(Long memberId, BoardStatus status) {
        return boardRepository.findByMemberIdAndStatusAndIsDeletedFalse(memberId, status).stream()
                .map(BoardRetrieveResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true) // TODO 하나씩 조회하기
    public BoardRetrieveResponseDto retrieveTodo(Long memberId, Long boardId, BoardStatus status) {
        Board findBoard = boardRepository.findByMemberIdAndIdAndStatusAndIsDeletedFalse(memberId, boardId, status);
        if (findBoard == null) {
            throw new NotFoundException("해당하는 todo가 존재하지 않습니다");
        }
        return new BoardRetrieveResponseDto(findBoard);
    }

    @Transactional
    public BoardPageResponseDto pageRequest(int page, int size) {
        Page<Board> boardList = boardRepository.findAll(PageRequest.of(page, size));
        return BoardPageResponseDto.builder()
                .contents(boardList.stream()
                        .map(BoardDto::of)
                        .collect(Collectors.toList()))
                .totalPages(boardList.getTotalPages())
                .totalElements(boardList.getTotalElements())
                .build();
    }

    @Transactional
    public BoardRetrieveResponseDto updateBoard(BoardUpdateRequestDto dto, Long memberId, Long id) {
        Board findBoard = boardRepository.findByMemberIdAndId(memberId, id);
        if (findBoard == null) {
            throw new NotFoundException("해당하는 투두가 존재하지 않습니다.");
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