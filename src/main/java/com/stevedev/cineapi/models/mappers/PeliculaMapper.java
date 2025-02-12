package com.stevedev.cineapi.models.mappers;

import com.stevedev.cineapi.models.dtos.request.CreatePeliculaReq;
import com.stevedev.cineapi.models.dtos.request.UpdatePeliculaReq;
import com.stevedev.cineapi.models.dtos.response.PeliculaRes;
import com.stevedev.cineapi.models.entities.ActorEntity;
import com.stevedev.cineapi.models.entities.PeliculaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {
    // Para crear una pelicula
    @Mapping(source = "director.nombre", target = "director")
    @Mapping(source = "genero.nombre", target = "genero")
    @Mapping(source = "actores", target = "actores", qualifiedByName = "mapActoresToString")
    PeliculaRes toResponseCreate(PeliculaEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "directorId", target = "director.id")
    @Mapping(source = "generoId", target = "genero.id")
    @Mapping(source = "actoresIds", target = "actores", qualifiedByName = "mapActores")
    PeliculaEntity toEntityCreate(CreatePeliculaReq req);

    // Para actualizar una pelicula
    @Mapping(source = "director.nombre", target = "director")
    @Mapping(source = "genero.nombre", target = "genero")
    @Mapping(source = "actores", target = "actores", qualifiedByName = "mapActoresToString")
    PeliculaRes toResponseUpdate(PeliculaEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "directorId", target = "director.id")
    @Mapping(source = "generoId", target = "genero.id")
    @Mapping(source = "actoresIds", target = "actores", qualifiedByName = "mapActores")
    PeliculaEntity toEntityUpdate(UpdatePeliculaReq req);

    // Metodos auxiliares para las listas

    @Named("mapActores")
    static List<ActorEntity> mapActores(List<Long> actoresIds) {
        if (actoresIds == null) return null;
        return actoresIds.stream().map(id -> {
            ActorEntity actor = new ActorEntity();
            actor.setId(id);
            return actor;
        }).collect(java.util.stream.Collectors.toList());
    }

    @Named("mapActoresToString")
    static List<String> mapActoresToString(List<ActorEntity> actores) {
        if (actores == null) return null;
        return actores.stream()
                .map(ActorEntity::getNombre)
                .collect(java.util.stream.Collectors.toList());
    }
}
