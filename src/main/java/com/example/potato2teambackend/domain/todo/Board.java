package com.example.potato2teambackend.domain.todo;

import com.example.potato2teambackend.domain.BaseTimeEntity;
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

    @Enumerated(EnumType.STRING)
    @Column
    private BoardStatus status;

    private boolean isDeleted;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private BoardColor color;

    @Builder
    public Board(Long id, String content, BoardColor color, Long memberId) {
        this.id = id;
        this.content = content;
        this.memberId = memberId;
        this.status = BoardStatus.TODO;
        this.isDeleted = false;
        this.color = color;
    }

    public void update(String content, BoardColor color, BoardStatus status) {
        this.content = content;
        this.color = color;
        this.status = status;
    }

}
