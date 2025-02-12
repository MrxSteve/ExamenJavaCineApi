package com.stevedev.cineapi.controllers;

import com.stevedev.cineapi.models.dtos.request.ActorReq;
import com.stevedev.cineapi.models.dtos.response.ActorRes;
import com.stevedev.cineapi.services.ActorServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actores")
@RequiredArgsConstructor
public class ActorController {
    private final ActorServiceImp actorService;

    // Crear un nuevo actor para poder asignarlo a una película desde cuando la estamos creando
    @PostMapping
    public ResponseEntity<ActorRes> create(@Valid @RequestBody ActorReq req) {
        ActorRes response = actorService.create(req);
        return ResponseEntity.status(201).body(response);
    }

    // Obtener todos los actores
    @GetMapping
    public ResponseEntity<Page<ActorRes>> findAll(Pageable pageable) {
        Page<ActorRes> response = actorService.findAll(pageable);
        return ResponseEntity.ok(response);
    }
}
