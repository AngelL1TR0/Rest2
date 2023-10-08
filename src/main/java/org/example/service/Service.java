package org.example.service;

import org.example.controllers.dto.JugadorEquipoDto;
import org.example.dao.JugadorDAO;
import org.example.entity.Jugador;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private JugadorDAO jugadorDAO;

    private JugadorService jugadorService;
    private EquipoService equipoService;


    public List<JugadorEquipoDto> getJugadorEquipo() {
        List<Jugador> jugadores = jugadorDAO.findAll();



        return jugadores.stream().map(jugador -> JugadorEquipoDto.toDto(jugador, jugador.getIdEquipo())).collect(Collectors.toList());
    }
}






