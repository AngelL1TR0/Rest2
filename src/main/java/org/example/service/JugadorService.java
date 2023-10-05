package org.example.service;

import org.example.dao.JugadorDAO;
import org.example.entity.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JugadorService {

    @Autowired
    private JugadorDAO jugadorDAO;

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

    public Jugador findJugador(int jugadorId) {
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

    public List<Jugador> listJugadoresPorEquipo(int equipoId) {
        return jugadorDAO.findByIdEquipo_Id(equipoId);
    }
}
