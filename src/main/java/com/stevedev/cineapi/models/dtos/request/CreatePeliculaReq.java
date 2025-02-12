package com.stevedev.cineapi.models.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreatePeliculaReq {
    @NotBlank(message = "El título es requerido")
    @Size(min = 1, max = 55, message = "El título debe tener entre 1 y 55 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción es requerida")
    @Size(min = 1, max = 200, message = "El título debe tener entre 1 y 200 caracteres")
    private String descripcion;

    private Long directorId;
    private Long generoId;
    private List<Long> actoresIds;
}
