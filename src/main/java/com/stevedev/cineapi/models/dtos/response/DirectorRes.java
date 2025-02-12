package com.stevedev.cineapi.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DirectorRes {
    private Long id;
    private String nombre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
