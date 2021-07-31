package com.example.potato2teambackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardPageRequest {
    private int page;
    private int size;

}
