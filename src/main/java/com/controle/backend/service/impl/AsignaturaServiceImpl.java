package com.controle.backend.service.impl;

import com.controle.backend.exception.ObjectNotFoundException;
import com.controle.backend.model.Area;
import com.controle.backend.model.Asignatura;
import com.controle.backend.repository.AreaRepository;
import com.controle.backend.repository.AsignaturaRepository;
import com.controle.backend.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    AreaRepository areaRepository;

    @Override
    public List<Asignatura> findAll() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura findOneAsignaturaById(Long asignaturaId) {
        return asignaturaRepository.findById(asignaturaId).orElseThrow(() -> new ObjectNotFoundException("[Asignatura: " + asignaturaId + "]"));
    }

    @Override
    public Asignatura createAsignatura(Asignatura asignatura) {
        Optional<Area> optionalArea = areaRepository.findById(asignatura.getAreaId());
        if (optionalArea.isPresent()){
            asignatura.setArea(optionalArea.get());
        } else {
            throw new ObjectNotFoundException("[Area: " + asignatura.getAreaId() + "]");
        }
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura updateOneAsignaturaById(Long asignaturaId, Asignatura asignatura) {
        Asignatura oldAsignatura = this.findOneAsignaturaById(asignaturaId);
        oldAsignatura.setNombre(asignatura.getNombre());
        oldAsignatura.setDescripcion(asignatura.getDescripcion());
        oldAsignatura.setEstado(asignatura.getEstado());
        oldAsignatura.setAreaId(asignatura.getAreaId());
        return asignaturaRepository.save(oldAsignatura);
    }

    @Override
    public void deleteOneAsignaturaById(Long asignaturaId) {
        if (asignaturaRepository.existsById(asignaturaId)){
            asignaturaRepository.deleteById(asignaturaId);
            return;
        }

        throw new ObjectNotFoundException("[Asignatura: " + asignaturaId + "]");
    }
}
