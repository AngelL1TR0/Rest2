package org.example.controllers;

import org.example.controllers.dto.JugadorEquipoDto;
import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jugadorEquipo")
public class JugadorEquipoController {

    @Autowired
    private Service service;

    @GetMapping
    public ResponseEntity<List<JugadorEquipoDto>> listaJugadorEquipo() {
        return ResponseEntity.ok(service.getJugadorEquipo());
    }
}
