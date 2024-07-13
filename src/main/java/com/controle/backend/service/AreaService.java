package com.controle.backend.service;

import com.controle.backend.model.Area;

import java.util.List;

public interface AreaService {

    List<Area> findAll();

    Area findOneAreaById(Long areaId);

    Area createArea(Area area);

    Area updateOneAreaById(Long areaId, Area area);

    void deleteOneAreaById(Long areaId);

}
