package org.example.service;

import org.example.controllers.dto.EquipoDto;
import org.example.dao.EquipoDAO;
import org.example.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoService {

    @Autowired
    private EquipoDAO equipoDAO;

    public List<EquipoDto> listEquipos() {
        List<Equipo> equipos = equipoDAO.findAll();
        return equipos.stream().map(EquipoDto::toDto).collect(Collectors.toList());
    }

    public boolean addEquipo(EquipoDto equipoDto) {
        try {
            equipoDAO.save(equipoDto.toEntity(equipoDto));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Equipo findEquipo(int equipoId) {
        return equipoDAO.findById(equipoId).orElse(null);
    }

    public void updateEquipo(Equipo equipo, EquipoDto equipoDto) {
        equipo.setId(equipoDto.getId());
        equipo.setNombre(equipoDto.getNombre());
        equipo.setCiudad(equipoDto.getCiudad());
        equipoDAO.save(equipo);
    }

    public boolean deleteEquipo(int equipoId) {
        try {
            equipoDAO.deleteById(equipoId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
