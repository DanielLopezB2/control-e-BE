package com.controle.backend.service;

import com.controle.backend.model.Estudiante;

import java.util.List;

public interface EstudianteService {

    List<Estudiante> findAll();

    Estudiante findOneEstudianteById(Long estudianteId);

    Estudiante createEstudiante(Estudiante estudiante);

    Estudiante updateOneEstudianteById(Long estudianteId, Estudiante estudiante);

    void deleteOneEstudianteById(Long estudianteId);
}
