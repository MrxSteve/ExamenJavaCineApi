package com.stevedev.cineapi.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private DirectorEntity director;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

    @ManyToMany
    @JoinTable(
            name = "peliculas_actores",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actores;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist()
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate()
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
