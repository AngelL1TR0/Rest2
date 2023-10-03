package org.example.service;

import org.example.dao.EquipoDAO;
import org.example.dao.JugadorDAO;
import org.example.dao.PatrocinadorDAO;
import org.example.entity.Equipo;
import org.example.entity.Jugador;
import org.example.entity.Patrocinador;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private EquipoDAO equipoDAO;

    @Autowired
    private JugadorDAO jugadorDAO;

    @Autowired
    private PatrocinadorDAO patrocinadorDAO;

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

    public Equipo updateEquipo(int equipoId) {
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

    public List<Jugador> listJugador() {
        return jugadorDAO.findAll();
    }

    public boolean addJugador(Jugador entity) {
        try {
            jugadorDAO.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Jugador updateJugador(int jugadorId) {
        return jugadorDAO.findById(jugadorId).orElse(null);
    }

    public boolean deleteJugador(int jugadorId) {
        try {
            jugadorDAO.deleteById(jugadorId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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

    public Patrocinador updatePatrocinador(int patrocinadorId) {
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
