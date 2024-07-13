package com.controle.backend.service;

import com.controle.backend.model.Asignatura;

import java.util.List;

public interface AsignaturaService {

    List<Asignatura> findAll();

    Asignatura findOneAsignaturaById(Long asignaturaId);

    Asignatura createAsignatura(Asignatura asignatura);

    Asignatura updateOneAsignaturaById(Long asignaturaId, Asignatura asignatura);

    void deleteOneAsignaturaById(Long asignaturaId);

}
