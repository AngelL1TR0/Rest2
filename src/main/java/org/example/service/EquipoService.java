package org.example.service;

import org.example.dao.EquipoDAO;
import org.example.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipoService {

    @Autowired
    private EquipoDAO equipoDAO;

    public List<Equipo> listEquipo() {
        return equipoDAO.findAll();
    }

    public boolean addEquipo(Equipo entity) {
        try {
            equipoDAO.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Equipo findEquipo(int equipoId) {
        return equipoDAO.findById(equipoId).orElse(null);
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
