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

    private boolean done;

    @Builder
    public Todo(String todo) {
        this.todo = todo;
        this.done = false;
    }

}
