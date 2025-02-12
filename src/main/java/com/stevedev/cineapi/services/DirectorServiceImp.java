package com.stevedev.cineapi.services;

import com.stevedev.cineapi.models.dtos.request.DirectorReq;
import com.stevedev.cineapi.models.dtos.response.DirectorRes;
import com.stevedev.cineapi.models.entities.DirectorEntity;
import com.stevedev.cineapi.models.mappers.DirectorMapper;
import com.stevedev.cineapi.repositories.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectorServiceImp {
    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    public DirectorRes create(DirectorReq req) {
        DirectorEntity entity = directorMapper.toEntity(req);
        DirectorEntity savedEntity = directorRepository.save(entity);

        return directorMapper.toResponse(savedEntity);
    }

    public Page<DirectorRes> findAll(Pageable pageable) {
        Page<DirectorEntity> entities = directorRepository.findAll(pageable);

        return entities.map(directorMapper::toResponse);
    }
}
