package com.example.potato2teambackend.dto.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByIsDoneAndIsDeletedFalse(boolean isDone);

}
