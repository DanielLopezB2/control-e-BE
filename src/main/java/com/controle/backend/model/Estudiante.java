package com.controle.backend.model;

import com.controle.backend.enums.Estado;
import com.controle.backend.enums.Genero;
import com.controle.backend.enums.TipoDocumentoIdentidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;

    @Column(nullable = false)
    private Long numeroDocumento;

    @Column(nullable = false)
    @Email(message = "Debe ingresar un email válido")
    private String email;

    private Long telefono;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate fechaCreacion;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate fechaUltimaModificacion;
}
