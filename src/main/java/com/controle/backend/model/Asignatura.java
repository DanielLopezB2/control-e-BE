package com.controle.backend.model;

import java.time.LocalDate;

import com.controle.backend.enums.Estado;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDate fechaCreacion;
    private LocalDate fechaUltimaModificacion;

    @Column(nullable = false, name = "area_id")
    private Long areaId;

    @ManyToOne
    @JoinColumn(name = "area_id", insertable = false, updatable = false)
    @JsonBackReference
    private Area area;
    
}
