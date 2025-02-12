package com.stevedev.cineapi.models.mappers;

import com.stevedev.cineapi.models.dtos.request.GeneroReq;
import com.stevedev.cineapi.models.dtos.response.GeneroRes;
import com.stevedev.cineapi.models.entities.GeneroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroMapper {
    GeneroRes toResponse(GeneroEntity entity);
    GeneroEntity toEntity(GeneroReq req);
}
