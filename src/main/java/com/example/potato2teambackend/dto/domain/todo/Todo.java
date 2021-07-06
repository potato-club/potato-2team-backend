package com.example.potato2teambackend.dto.domain.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String todo;

    @Builder
    public Todo(String todo) {
        this.todo = todo;
    }

}
