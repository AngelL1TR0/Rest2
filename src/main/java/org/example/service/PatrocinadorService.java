package org.example.service;

import org.example.dao.PatrocinadorDAO;
import org.example.entity.Jugador;
import org.example.entity.Patrocinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatrocinadorService {

    @Autowired
    private PatrocinadorDAO patrocinadorDAO;

    public List<Patrocinador> listPatrocinador() {
        return patrocinadorDAO.findAll();
    }

    public boolean addPatrocinador(Patrocinador entity) {
        try {
            patrocinadorDAO.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Patrocinador findPatrocinador(int patrocinadorId) {
        return patrocinadorDAO.findById(patrocinadorId).orElse(null);
    }

    public boolean deletePatrocinador(int patrocinadorId) {
        try {
            patrocinadorDAO.deleteById(patrocinadorId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

