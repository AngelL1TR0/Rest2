package org.example.service;

import org.example.controllers.dto.JugadorDto;
import org.example.dao.EquipoDAO;
import org.example.dao.JugadorDAO;
import org.example.entity.Equipo;
import org.example.entity.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorService {
    @Autowired
    private JugadorDAO jugadorDAO;
    @Autowired
    private EquipoDAO equipoDAO;

    public List<JugadorDto> listJugador() {
        List<Jugador> jugadores = jugadorDAO.findAll();
        return jugadores.stream().map(JugadorDto::toDto).collect(Collectors.toList());
    }
    public boolean addJugador(JugadorDto jugadorDto) {
        try {
            jugadorDAO.save(jugadorDto.toEntity(jugadorDto));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Jugador findJugador(int jugadorId) {
        return jugadorDAO.findById(jugadorId).orElse(null);
    }

    public void updateJugador(Jugador jugador, JugadorDto jugadorDto) {
        jugador.setId(jugadorDto.getId());
        jugador.setNombre(jugadorDto.getNombre());
        jugador.setDorsal(jugadorDto.getDorsal());
        jugadorDAO.save(jugador);
    }

    public boolean deleteJugador(int jugadorId) {
        try {
            Jugador jugador = findJugador(jugadorId);
            if (jugador != null) {
                Equipo equipo = jugador.getIdEquipo();
                List<Jugador> jugadoresEnEquipo = listJugadoresPorEquipo(equipo.getId());
                if (jugadoresEnEquipo.size() == 1) {
                    jugadorDAO.deleteById(jugadorId);
                    equipoDAO.deleteById(equipo.getId());
                } else {
                    jugadorDAO.deleteById(jugadorId);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Jugador> listJugadoresPorEquipo(int equipoId) {
        return jugadorDAO.findByIdEquipo_Id(equipoId);
    }

}
