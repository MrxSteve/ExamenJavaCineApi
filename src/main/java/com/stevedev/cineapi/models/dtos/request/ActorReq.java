package com.stevedev.cineapi.models.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ActorReq {
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 1, max = 55, message = "El nombre debe tener entre 1 y 55 caracteres")
    private String nombre;

    @NotNull(message = "La fecha de nacimiento es requerida, yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
}
