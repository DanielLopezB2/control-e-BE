package com.controle.backend.controller;

import com.controle.backend.exception.ObjectNotFoundException;
import com.controle.backend.model.Area;
import com.controle.backend.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
@CrossOrigin(origins = "http://localhost:4200")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Area>> findAll() {
        return ResponseEntity.ok(areaService.findAll());
    }

    @GetMapping("/{areaId}")
    public ResponseEntity<Area> findOneAreaById(@PathVariable("areaId") Long areaId) {
        try {
            return ResponseEntity.ok(areaService.findOneAreaById(areaId));
        } catch (ObjectNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Area> createArea(@RequestBody Area area) {
        return ResponseEntity.ok(areaService.createArea(area));
    }

    @PutMapping("/{areaId}")
    public ResponseEntity<Area> updateOneAreaById(@PathVariable("areaId") Long areaId, @RequestBody Area area) {
        return ResponseEntity.ok(areaService.updateOneAreaById(areaId, area));
    }

    @DeleteMapping("/{areaId}")
    public ResponseEntity<String> deleteOneAreaById(@PathVariable("areaId") Long areaId) {
        areaService.deleteOneAreaById(areaId);
        return ResponseEntity.ok().build();
    }



}
