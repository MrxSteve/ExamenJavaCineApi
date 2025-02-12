package com.stevedev.cineapi.models.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DirectorReq {
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 1, max = 55, message = "El nombre debe tener entre 1 y 55 caracteres")
    private String nombre;
}
