package com.stevedev.cineapi.repositories;

import com.stevedev.cineapi.models.entities.ActorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
    // Consulta para obtener los 5 actores más frecuentes en películas
    Page<ActorEntity> findTop5ByOrderByPeliculasDesc(Pageable pageable);
}
