package org.example.controllers;

import org.example.controllers.dto.EquipoDto;
import org.example.controllers.dto.JugadorDto;
import org.example.entity.Equipo;
import org.example.entity.Jugador;
import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
public class JugadorController {

    @Autowired
    private Service service;
    @GetMapping(path = "/jugadores")
    public ResponseEntity<List<JugadorDto>> list() {
        return ResponseEntity.ok(service.listJugador()
                .stream()
                .map(JugadorDto::toDto)
                .collect(Collectors.toList())
        );
    }


    @PostMapping(path = "/jugadores")
    public ResponseEntity<Void> add(
            @Valid @RequestBody JugadorDto jugadorDto
    ) { if (service.addJugador(jugadorDto.toEntity(jugadorDto))) {
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
        Jugador s = service.updateJugador(jugadorId);
        if (s != null) {
            s.setId(jugador.getId());
            s.setNombre(jugador.getNombre());
            s.setDorsal(jugador.getDorsal());
            service.addJugador(s);
            return ResponseEntity.ok().body(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/jugadores/{jugadorId}")
    public ResponseEntity<Void> delete(
            @PathVariable("jugadorId") int jugadorId) {
        if (service.deleteJugador(jugadorId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


