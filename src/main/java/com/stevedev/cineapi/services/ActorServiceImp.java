package com.stevedev.cineapi.services;

import com.stevedev.cineapi.models.dtos.request.ActorReq;
import com.stevedev.cineapi.models.dtos.response.ActorRes;
import com.stevedev.cineapi.models.entities.ActorEntity;
import com.stevedev.cineapi.models.mappers.ActorMapper;
import com.stevedev.cineapi.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImp {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public ActorRes create(ActorReq req) {
        ActorEntity entity = actorMapper.toEntity(req);
        ActorEntity savedEntity = actorRepository.save(entity);

        return actorMapper.toResponse(savedEntity);
    }

    public Page<ActorRes> findAll(Pageable pageable) {
        Page<ActorEntity> entities = actorRepository.findAll(pageable);

        return entities.map(actorMapper::toResponse);
    }
}
