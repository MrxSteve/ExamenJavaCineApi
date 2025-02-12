package com.stevedev.cineapi.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "generos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

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

    @OneToMany(
            mappedBy = "genero",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<PeliculaEntity> peliculas;
}
