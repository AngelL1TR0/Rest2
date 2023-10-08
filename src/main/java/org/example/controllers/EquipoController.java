package org.example.controllers;

import org.example.controllers.dto.EquipoDto;
import org.example.entity.Equipo;
import org.example.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService service;

    @GetMapping
    public ResponseEntity<List<EquipoDto>> listEquipos() {
        return ResponseEntity.ok(service.listEquipos());
    }

    @PostMapping
    public ResponseEntity<Void> addEquipo(@Valid @RequestBody EquipoDto equipoDto) {
        if (service.addEquipo(equipoDto)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{equipoId}")
    public ResponseEntity<Equipo> updateEquipo(
            @PathVariable("equipoId") int equipoId,
            @Valid @RequestBody EquipoDto equipoDto
    ) {
        Equipo equipo = service.findEquipo(equipoId);
        if (equipo != null) {
            service.updateEquipo(equipo, equipoDto);
            return ResponseEntity.ok(equipo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{equipoId}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable("equipoId") int equipoId) {
        if (service.deleteEquipo(equipoId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


