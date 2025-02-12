package com.stevedev.cineapi.controllers;

import com.stevedev.cineapi.models.dtos.request.GeneroReq;
import com.stevedev.cineapi.models.dtos.response.GeneroRes;
import com.stevedev.cineapi.services.GeneroServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/generos")
@RequiredArgsConstructor
public class GeneroController {
    private final GeneroServiceImp generoService;

    // Crear un nuevo género para poder asignarlo a una película desde cuando la estamos creando
    @PostMapping
    public ResponseEntity<GeneroRes> create(@Valid @RequestBody GeneroReq req) {
        GeneroRes response = generoService.create(req);
        return ResponseEntity.status(201).body(response);
    }

    // Obtener todos los géneros paginados
    @GetMapping
    public ResponseEntity<Page<GeneroRes>> findAll(Pageable pageable) {
        Page<GeneroRes> response = generoService.findAll(pageable);
        return ResponseEntity.ok(response);
    }
}
