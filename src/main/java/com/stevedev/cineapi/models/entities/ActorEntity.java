package com.stevedev.cineapi.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "actores")
    private List<PeliculaEntity> peliculas;

    @PrePersist()
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate()
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
