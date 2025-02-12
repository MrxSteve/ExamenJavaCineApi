package com.stevedev.cineapi.controllers;

import com.stevedev.cineapi.models.dtos.request.DirectorReq;
import com.stevedev.cineapi.models.dtos.response.DirectorRes;
import com.stevedev.cineapi.services.DirectorServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/directores")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorServiceImp directorService;

    // Crear un nuevo director para poder asignarlo a una película desde cuando la estamos creando
    @PostMapping
    public ResponseEntity<DirectorRes> create(@Valid @RequestBody DirectorReq req) {
        DirectorRes response = directorService.create(req);
        return ResponseEntity.status(201).body(response);
    }

    // Obtener todos los directores paginados
    @GetMapping
    public ResponseEntity<Page<DirectorRes>> findAll(Pageable pageable) {
        Page<DirectorRes> response = directorService.findAll(pageable);
        return ResponseEntity.ok(response);
    }
}
