package com.stevedev.cineapi.models.dtos.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ActorRes {
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
