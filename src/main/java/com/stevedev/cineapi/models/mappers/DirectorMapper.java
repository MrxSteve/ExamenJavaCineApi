package com.stevedev.cineapi.models.mappers;

import com.stevedev.cineapi.models.dtos.request.DirectorReq;
import com.stevedev.cineapi.models.dtos.response.DirectorRes;
import com.stevedev.cineapi.models.entities.DirectorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorRes toResponse(DirectorEntity entity);
    DirectorEntity toEntity(DirectorReq req);
}
