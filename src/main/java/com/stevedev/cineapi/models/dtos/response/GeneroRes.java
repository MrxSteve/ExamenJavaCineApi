package com.stevedev.cineapi.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GeneroRes {
    private Long id;
    private String nombre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
