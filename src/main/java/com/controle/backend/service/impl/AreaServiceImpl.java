package com.controle.backend.service.impl;

import com.controle.backend.exception.ObjectNotFoundException;
import com.controle.backend.model.Area;
import com.controle.backend.repository.AreaRepository;
import com.controle.backend.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public Area findOneAreaById(Long areaId) {
        return areaRepository.findById(areaId).orElseThrow(() -> new ObjectNotFoundException("[Area: " + areaId + "]"));
    }

    @Override
    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area updateOneAreaById(Long areaId, Area area) {
        Area oldArea = this.findOneAreaById(areaId);
        oldArea.setNombre(area.getNombre());
        oldArea.setDescripcion(area.getDescripcion());
        oldArea.setEstado(area.getEstado());
        oldArea.setAsignaturas(area.getAsignaturas());
        return areaRepository.save(oldArea);
    }

    @Override
    public void deleteOneAreaById(Long areaId) {
        if(areaRepository.existsById(areaId)){
            areaRepository.deleteById(areaId);
            return;
        }

        throw new ObjectNotFoundException("[Area: " + areaId + "]");
    }
}
