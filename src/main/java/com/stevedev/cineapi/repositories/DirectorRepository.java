package com.stevedev.cineapi.repositories;

import com.stevedev.cineapi.models.entities.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {
}
