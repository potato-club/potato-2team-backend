package com.example.potato2teambackend.domain.member;

import com.example.potato2teambackend.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate birth;

    private boolean isDeleted;

    @Builder
    public Member(String email, String name, String password, LocalDate birth) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.isDeleted = false;
    }

}
