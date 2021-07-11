package com.example.potato2teambackend.dto.domain.todo;

import com.example.potato2teambackend.dto.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String todo;

    @Column(nullable = false)
    private Long memberId;

    private boolean done;

    private boolean isDeleted;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private BoardColor color;

    @Builder
    public Board(Long id, String todo, Long memberId, BoardColor color) {
        this.id = id;
        this.todo = todo;
        this.memberId = memberId;
        this.done = false;
        this.isDeleted = false;
        this.color = color;
    }

}
