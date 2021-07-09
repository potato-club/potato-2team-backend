package com.example.potato2teambackend.dto.domain.todo;

import com.example.potato2teambackend.dto.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Todo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String todo;

    private int memberId;

    private boolean done;

    private boolean isDeleted;

    @Builder
    public Todo(String todo, int memberId) {
        this.todo = todo;
        this.memberId = memberId;
        this.done = false;
        this.isDeleted = false;
    }

}
