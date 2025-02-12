package com.stevedev.cineapi.controllers;

import com.stevedev.cineapi.models.dtos.request.CreatePeliculaReq;
import com.stevedev.cineapi.models.dtos.request.UpdatePeliculaReq;
import com.stevedev.cineapi.models.dtos.response.ActorRes;
import com.stevedev.cineapi.models.dtos.response.PeliculaRes;
import com.stevedev.cineapi.services.PeliculaServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peliculas")
@RequiredArgsConstructor
public class PeliculaController {
    private final PeliculaServiceImp peliculaService;

    // Crear una nueva película
    @PostMapping
    public ResponseEntity<PeliculaRes> create(@Valid @RequestBody CreatePeliculaReq req) {
        PeliculaRes response = peliculaService.create(req);
        return ResponseEntity.status(201).body(response);
    }

    // Actualizar una película
    @PutMapping("/{id}")
    public ResponseEntity<PeliculaRes> update(@PathVariable Long id, @Valid @RequestBody UpdatePeliculaReq req) {
        PeliculaRes response = peliculaService.update(id, req);
        return ResponseEntity.ok(response);
    }

    // Eliminar una película
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        peliculaService.delete(id);
        return ResponseEntity.ok("Película eliminada correctamente.");
    }

    // Obtener todas las películas paginadas
    @GetMapping
    public ResponseEntity<Page<PeliculaRes>> findAll(Pageable pageable) {
        Page<PeliculaRes> response = peliculaService.findAll(pageable);
        return ResponseEntity.ok(response);
    }

    // Obtener una película por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PeliculaRes> findById(@PathVariable Long id) {
        PeliculaRes response = peliculaService.findById(id);
        return ResponseEntity.ok(response);
    }

    // Obtener películas dirigidas por un director
    @GetMapping("/directores/{directorId}")
    public ResponseEntity<Page<PeliculaRes>> findByDirector(@PathVariable Long directorId, Pageable pageable) {
        Page<PeliculaRes> response = peliculaService.findByDirector(directorId, pageable);
        return ResponseEntity.ok(response);
    }

    // Obtener películas de un género
    @GetMapping("/generos/{generoId}")
    public ResponseEntity<Page<PeliculaRes>> findByGenero(@PathVariable Long generoId, Pageable pageable) {
        Page<PeliculaRes> response = peliculaService.findByGenero(generoId, pageable);
        return ResponseEntity.ok(response);
    }

    // Asignar un actor a una película
    @PostMapping("/{peliculaId}/actores/{actorId}")
    public ResponseEntity<String> asignarActor(@PathVariable Long peliculaId, @PathVariable Long actorId) {
        peliculaService.asignarActor(peliculaId, actorId);
        return ResponseEntity.ok("Actor asignado a la película correctamente.");
    }

    // Eliminar un actor de una película
    @DeleteMapping("/{peliculaId}/actores/{actorId}")
    public ResponseEntity<String> eliminarActor(@PathVariable Long peliculaId, @PathVariable Long actorId) {
        peliculaService.eliminarActor(peliculaId, actorId);
        return ResponseEntity.ok("Actor eliminado de la película correctamente.");
    }

    // Obtener los 5 actores que más aparecen en películas
    @GetMapping("/actores/top")
    public ResponseEntity<Page<ActorRes>> obtenerTop5Actores(Pageable pageable) {
        Page<ActorRes> response = peliculaService.obtenerTop5Actores(pageable);
        return ResponseEntity.ok(response);
    }
}
