package com.controle.backend.controller;

import com.controle.backend.exception.ObjectNotFoundException;
import com.controle.backend.model.Asignatura;
import com.controle.backend.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
@CrossOrigin(origins = "http://localhost:4200")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Asignatura>> findAll() {
        return ResponseEntity.ok(asignaturaService.findAll());
    }

    @GetMapping("/{asignaturaId}")
    public ResponseEntity<Asignatura> findOneAsignaturaById(@PathVariable("asignaturaId") Long asignaturaId) {
        try {
            return ResponseEntity.ok(asignaturaService.findOneAsignaturaById(asignaturaId));
        } catch (ObjectNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura asignatura) {
        return ResponseEntity.ok(asignaturaService.createAsignatura(asignatura));
    }

    @PutMapping("/{asignaturaId}")
    public ResponseEntity<Asignatura> updateOneAsignaturaById(@PathVariable("asignaturaId") Long asignaturaId, @RequestBody Asignatura asignatura) {
        return ResponseEntity.ok(asignaturaService.updateOneAsignaturaById(asignaturaId, asignatura));
    }

    @DeleteMapping("/{asignaturaId}")
    public ResponseEntity<String> deleteOneAsignaturaById(@PathVariable("asignaturaId") Long asignaturaId) {
        asignaturaService.deleteOneAsignaturaById(asignaturaId);
        return ResponseEntity.ok().build();
    }



}
