package com.stevedev.cineapi.services;

import com.stevedev.cineapi.models.dtos.request.GeneroReq;
import com.stevedev.cineapi.models.dtos.response.GeneroRes;
import com.stevedev.cineapi.models.entities.GeneroEntity;
import com.stevedev.cineapi.models.mappers.GeneroMapper;
import com.stevedev.cineapi.repositories.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneroServiceImp {
    private final GeneroRepository generoRepository;
    private final GeneroMapper generoMapper;

    public GeneroRes create(GeneroReq req) {
        GeneroEntity entity = generoMapper.toEntity(req);
        GeneroEntity savedEntity = generoRepository.save(entity);

        return generoMapper.toResponse(savedEntity);
    }

    public Page<GeneroRes> findAll(Pageable pageable) {
        Page<GeneroEntity> entities = generoRepository.findAll(pageable);

        return entities.map(generoMapper::toResponse);
    }
}
