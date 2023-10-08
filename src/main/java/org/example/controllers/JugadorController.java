package org.example.controllers;

import org.example.controllers.dto.JugadorDto;
import org.example.entity.Equipo;
import org.example.entity.Jugador;
import org.example.service.JugadorService;
import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService service;

    @GetMapping
    public ResponseEntity<List<JugadorDto>> list() {
        return ResponseEntity.ok(service.listJugador());
    }

    @PostMapping
    public ResponseEntity<Void> add(
            @Valid @RequestBody JugadorDto jugadorDto) {
        if (service.addJugador(jugadorDto)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{jugadorId}")
    public ResponseEntity<Jugador> update(
            @PathVariable("jugadorId") int jugadorId,
            @Valid @RequestBody JugadorDto jugadorDto
    ) {
        Jugador jugador = service.findJugador(jugadorId);
        if (jugador != null) {
            service.updateJugador(jugador, jugadorDto);
            return ResponseEntity.ok(jugador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(path = "/{jugadorId}")
    public ResponseEntity<Void> delete(@PathVariable("jugadorId") int jugadorId) {
        boolean jugadorEliminado = service.deleteJugador(jugadorId);

        if (jugadorEliminado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



