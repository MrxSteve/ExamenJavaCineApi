package com.stevedev.cineapi.repositories;

import com.stevedev.cineapi.models.entities.PeliculaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
    Page<PeliculaEntity> findByDirector_Id(Long directorId, Pageable pageable);
    Page<PeliculaEntity> findByGenero_Id(Long generoId, Pageable pageable);
}
