package com.stevedev.cineapi.models.mappers;

import com.stevedev.cineapi.models.dtos.request.ActorReq;
import com.stevedev.cineapi.models.dtos.response.ActorRes;
import com.stevedev.cineapi.models.entities.ActorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorRes toResponse(ActorEntity entity);
    ActorEntity toEntity(ActorReq req);
}
