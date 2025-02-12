package com.stevedev.cineapi.models.dtos.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UpdatePeliculaReq {
    @Size(min = 1, max = 55, message = "El título debe tener entre 1 y 55 caracteres")
    private String titulo;

    @Size(min = 1, max = 200, message = "El título debe tener entre 1 y 200 caracteres")
    private String descripcion;

    private Long directorId;

    private Long generoId;

    private List<Long> actoresIds;
}
