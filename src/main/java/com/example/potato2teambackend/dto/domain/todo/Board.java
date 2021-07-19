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
    private String content;

    @Column(nullable = false)
    private Long memberId;

    private boolean isDone;

    private boolean isDeleted;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private BoardColor color;

    @Builder
    public Board(Long id, String content, Long memberId, BoardColor color) {
        this.id = id;
        this.content = content;
        this.memberId = memberId;
        this.isDone = false;
        this.isDeleted = false;
        this.color = color;
    }

}
