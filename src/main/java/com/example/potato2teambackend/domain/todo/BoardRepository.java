package com.example.potato2teambackend.domain.todo;

import com.example.potato2teambackend.dto.BoardCreateRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByMemberIdAndStatusAndIsDeletedFalse(Long memberId, BoardStatus status);

}
