package com.example.potato2teambackend.domain.todo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByMemberIdAndStatusAndIsDeletedFalse(Long memberId, BoardStatus status);

    Board findByMemberIdAndIdAndStatusAndIsDeletedFalse(Long memberId, Long id, BoardStatus status);

    Board findByMemberIdAndId(Long memberId, Long id);

    Page<Board> findAll(Pageable pageable);

}
