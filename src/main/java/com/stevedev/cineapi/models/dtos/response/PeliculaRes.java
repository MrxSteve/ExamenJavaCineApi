package com.stevedev.cineapi.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PeliculaRes {
    private Long id;
    private String titulo;
    private String descripcion;
    private String director;
    private String genero;
    private List<String> actores;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
