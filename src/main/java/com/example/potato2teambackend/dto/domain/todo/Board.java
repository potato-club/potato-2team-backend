package com.example.potato2teambackend.dto.domain.todo;

import com.example.potato2teambackend.dto.domain.BaseTimeEntity;
import com.sun.xml.bind.v2.TODO;
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
    public Board(Long id, String content, Long memberId, BoardColor color) {
        this.id = id;
        this.content = content;
        this.memberId = memberId;
        this.status = BoardStatus.TODO;
        this.isDeleted = false;
        this.color = color;
    }

}
