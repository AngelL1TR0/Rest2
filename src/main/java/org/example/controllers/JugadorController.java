package org.example.controllers;

import org.example.controllers.dto.JugadorDto;
import org.example.entity.Equipo;
import org.example.entity.Jugador;
import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JugadorController {

    @Autowired
    private Service service;

    @GetMapping(path = "/jugadores")
    public ResponseEntity<List<JugadorDto>> list() {
        return ResponseEntity.ok(service.getJugadorService().listJugador()
                .stream()
                .map(JugadorDto::toDto)
                .collect(Collectors.toList())
        );
    }

    @PostMapping(path = "/jugadores")
    public ResponseEntity<Void> add(
            @Valid @RequestBody JugadorDto jugadorDto
    ) {
        if (service.getJugadorService().addJugador(jugadorDto.toEntity(jugadorDto))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping(path = "/jugadores/{jugadorId}")
    public ResponseEntity<Jugador> update(
            @PathVariable("jugadorId") int jugadorId,
            @Valid @RequestBody JugadorDto jugador
    ) {
        Jugador s = service.getJugadorService().findJugador(jugadorId);
        if (s != null) {
            s.setId(jugador.getId());
            s.setNombre(jugador.getNombre());
            s.setDorsal(jugador.getDorsal());
            service.getJugadorService().addJugador(s);
            return ResponseEntity.ok().body(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Nuevo ejercicio, modificar este endpoint
    // para añadir que si ya no hay jugadores en ese equipo
    // se borre el equipo
    @DeleteMapping(path = "/jugadores/{jugadorId}")
    public ResponseEntity<Void> delete
    (@PathVariable("jugadorId") int jugadorId) {
        Jugador jugador = service.getJugadorService().findJugador(jugadorId);
        Equipo equipo = jugador.getIdEquipo();
        List<Jugador> jugadoresEnEquipo = service.getJugadorService().listJugadoresPorEquipo(equipo.getId());

        if (jugadoresEnEquipo.size() == 1) {
            service.getJugadorService().deleteJugador(jugadorId);
            service.getEquipoService().deleteEquipo(equipo.getId());
            return ResponseEntity.ok().build();
        } else {
            service.getJugadorService().deleteJugador(jugadorId);
            return ResponseEntity.ok().build();
        }
    }
}



