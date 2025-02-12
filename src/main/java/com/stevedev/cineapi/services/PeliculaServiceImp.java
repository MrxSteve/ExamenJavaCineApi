package com.stevedev.cineapi.services;

import com.stevedev.cineapi.models.dtos.request.CreatePeliculaReq;
import com.stevedev.cineapi.models.dtos.request.UpdatePeliculaReq;
import com.stevedev.cineapi.models.dtos.response.ActorRes;
import com.stevedev.cineapi.models.dtos.response.PeliculaRes;
import com.stevedev.cineapi.models.entities.ActorEntity;
import com.stevedev.cineapi.models.entities.DirectorEntity;
import com.stevedev.cineapi.models.entities.GeneroEntity;
import com.stevedev.cineapi.models.entities.PeliculaEntity;
import com.stevedev.cineapi.models.mappers.ActorMapper;
import com.stevedev.cineapi.models.mappers.PeliculaMapper;
import com.stevedev.cineapi.repositories.ActorRepository;
import com.stevedev.cineapi.repositories.DirectorRepository;
import com.stevedev.cineapi.repositories.GeneroRepository;
import com.stevedev.cineapi.repositories.PeliculaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeliculaServiceImp {
    private final PeliculaRepository peliculaRepository;
    private final PeliculaMapper peliculaMapper;
    private final DirectorRepository directorRepository;
    private final GeneroRepository generoRepository;
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public PeliculaRes create(CreatePeliculaReq req) {
        PeliculaEntity entity = peliculaMapper.toEntityCreate(req);
        PeliculaEntity savedEntity = peliculaRepository.save(entity);

        return peliculaMapper.toResponseCreate(savedEntity);
    }

    public PeliculaRes update(Long id, UpdatePeliculaReq req) {
        PeliculaEntity entity = peliculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pelicula con ID: " + id + " no encontrada"));

        if (req.getTitulo() != null && !req.getTitulo().isEmpty()) {
            entity.setTitulo(req.getTitulo());
        }

        if (req.getDescripcion() != null && !req.getDescripcion().isEmpty()) {
            entity.setDescripcion(req.getDescripcion());
        }

        if (req.getDirectorId() != null && !entity.getDirector().getId().equals(req.getDirectorId())) {
            DirectorEntity director = directorRepository.findById(req.getDirectorId())
                    .orElseThrow(() -> new EntityNotFoundException("Director con ID " + req.getDirectorId() + " no encontrado"));
            entity.setDirector(director);
        }

        if (req.getGeneroId() != null && !entity.getGenero().getId().equals(req.getGeneroId())) {
            GeneroEntity genero = generoRepository.findById(req.getGeneroId())
                    .orElseThrow(() -> new EntityNotFoundException("Genero con ID " + req.getGeneroId() + " no encontrado"));
            entity.setGenero(genero);
        }

        if (req.getActoresIds() != null && !req.getActoresIds().isEmpty()) {
            List<Long> nuevosActoresIds = req.getActoresIds();
            List<Long> actualesActoresIds = entity.getActores().stream().map(actor -> actor.getId()).toList();

            if (!actualesActoresIds.equals(nuevosActoresIds)) {
                List<ActorEntity> nuevosActores = actorRepository.findAllById(nuevosActoresIds);
                entity.setActores(nuevosActores);
            }
        }

        PeliculaEntity updatedEntity = peliculaRepository.save(entity);

        return peliculaMapper.toResponseUpdate(updatedEntity);
    }

    public void delete(Long id) {
        PeliculaEntity entity = peliculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pelicula con ID: " + id + " no encontrada"));

        peliculaRepository.delete(entity);
    }

    public Page<PeliculaRes> findAll(Pageable pageable) {
        Page<PeliculaEntity> entities = peliculaRepository.findAll(pageable);

        return entities.map(peliculaMapper::toResponseCreate);
    }

    public PeliculaRes findById(Long id) {
        PeliculaEntity entity = peliculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pelicula con ID: " + id + " no encontrada"));

        return peliculaMapper.toResponseCreate(entity);
    }

    public Page<PeliculaRes> findByDirector(Long directorId, Pageable pageable) {
        Page<PeliculaEntity> entities = peliculaRepository.findByDirector_Id(directorId, pageable);

        if (entities.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron películas para el director con ID: " + directorId);
        }

        return entities.map(peliculaMapper::toResponseCreate);
    }

    public Page<PeliculaRes> findByGenero(Long generoId, Pageable pageable) {
        Page<PeliculaEntity> entities = peliculaRepository.findByGenero_Id(generoId, pageable);

        if (entities.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron películas para el género con ID: " + generoId);
        }

        return entities.map(peliculaMapper::toResponseCreate);
    }

    public void asignarActor(Long peliculaId, Long actorId) {
        PeliculaEntity pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(() -> new EntityNotFoundException("Película no encontrada con ID: " + peliculaId));

        ActorEntity actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException("Actor no encontrado con ID: " + actorId));

        if (!pelicula.getActores().contains(actor)) {
            pelicula.getActores().add(actor);
            peliculaRepository.save(pelicula);
        }
    }

    public void eliminarActor(Long peliculaId, Long actorId) {
        PeliculaEntity pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(() -> new EntityNotFoundException("Película no encontrada con ID: " + peliculaId));

        ActorEntity actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException("Actor no encontrado con ID: " + actorId));

        if (pelicula.getActores().contains(actor)) {
            pelicula.getActores().remove(actor);
            peliculaRepository.save(pelicula);
        }
    }

    public Page<ActorRes> obtenerTop5Actores(Pageable pageable) {
        Page<ActorEntity> entities = actorRepository.findTop5ByOrderByPeliculasDesc(pageable);

        return entities.map(actorMapper::toResponse);
    }
}
