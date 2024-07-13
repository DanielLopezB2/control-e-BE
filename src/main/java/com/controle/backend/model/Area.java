package com.controle.backend.model;

import java.time.LocalDate;
import java.util.List;

import com.controle.backend.enums.Estado;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Area {

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "area")
    @JsonManagedReference
    private List<Asignatura> asignaturas;

}
