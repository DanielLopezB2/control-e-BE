package com.controle.backend.service.impl;

import com.controle.backend.exception.ObjectNotFoundException;
import com.controle.backend.model.Estudiante;
import com.controle.backend.repository.EstudianteRepository;
import com.controle.backend.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findOneEstudianteById(Long estudianteId) {
        return estudianteRepository.findById(estudianteId).orElseThrow(() -> new ObjectNotFoundException("[Estudiante: " + estudianteId + "]"));
    }

    @Override
    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante updateOneEstudianteById(Long estudianteId, Estudiante estudiante) {
        Estudiante oldEstudiante = this.findOneEstudianteById(estudianteId);
        oldEstudiante.setNombres(estudiante.getNombres());
        oldEstudiante.setApellidos(estudiante.getApellidos());
        oldEstudiante.setTipoDocumentoIdentidad(estudiante.getTipoDocumentoIdentidad());
        oldEstudiante.setNumeroDocumento(estudiante.getNumeroDocumento());
        oldEstudiante.setEmail(estudiante.getEmail());
        oldEstudiante.setTelefono(estudiante.getTelefono());
        oldEstudiante.setGenero(estudiante.getGenero());
        oldEstudiante.setEstado(estudiante.getEstado());
        oldEstudiante.setFechaCreacion(estudiante.getFechaCreacion());
        oldEstudiante.setFechaUltimaModificacion(estudiante.getFechaUltimaModificacion());
        return estudianteRepository.save(oldEstudiante);
    }

    @Override
    public void deleteOneEstudianteById(Long estudianteId) {
        if (estudianteRepository.existsById(estudianteId)){
            estudianteRepository.deleteById(estudianteId);
            return;
        }

        throw new ObjectNotFoundException("[Estudiante: " + estudianteId + "]");

    }
}
