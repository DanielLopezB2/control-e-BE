package com.controle.backend.controller;

import com.controle.backend.exception.ObjectNotFoundException;
import com.controle.backend.model.Area;
import com.controle.backend.model.Estudiante;
import com.controle.backend.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiante")
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Estudiante>> findAll() {
        return ResponseEntity.ok(estudianteService.findAll());
    }

    @GetMapping("/{estudianteId}")
    public ResponseEntity<Estudiante> findOneEstudianteById(@PathVariable("estudianteId") Long estudianteId) {
        try {
            return ResponseEntity.ok(estudianteService.findOneEstudianteById(estudianteId));
        } catch (ObjectNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.createEstudiante(estudiante));
    }

    @PutMapping("/{estudianteId}")
    public ResponseEntity<Estudiante> updateOneEstudianteById(@PathVariable("estudianteId") Long estudianteId, @RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.updateOneEstudianteById(estudianteId, estudiante));
    }

    @DeleteMapping("/{estudianteId}")
    public ResponseEntity<String> deleteOneEstudianteById(@PathVariable("estudianteId") Long estudianteId) {
        estudianteService.deleteOneEstudianteById(estudianteId);
        return ResponseEntity.ok().build();
    }

}
