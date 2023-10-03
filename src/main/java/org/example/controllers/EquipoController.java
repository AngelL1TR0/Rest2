package org.example.controllers;

import org.example.controllers.dto.EquipoDto;
import org.example.entity.Equipo;
import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class EquipoController {

    @Autowired
    private Service service;

    @GetMapping(path = "/equipos")
    public ResponseEntity<List<EquipoDto>> list() {
        return ResponseEntity.ok(service.listEquipo()
                .stream()
                .map(EquipoDto::toDto)
                .collect(Collectors.toList())
        );
    }


    @PostMapping(path = "/equipos")
    public ResponseEntity<Void> add(
            @Valid @RequestBody EquipoDto equipoDto
    ) { if (service.addEquipo(equipoDto.toEntity(equipoDto))) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    }

    @PutMapping(path = "/equipos/{equipoId}")
    public ResponseEntity<Equipo> update(
            @PathVariable("equipoId") int equipoId,
            @Valid @RequestBody EquipoDto equipo
    ) {
        Equipo s = service.updateEquipo(equipoId);
        if (s != null) {
            s.setId(equipo.getId());
            s.setNombre(equipo.getNombre());
            s.setCiudad(equipo.getCiudad());
            service.addEquipo(s);
            return ResponseEntity.ok().body(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/equipos/{equipoId}")
    public ResponseEntity<Void> delete(
            @PathVariable("equipoId") int equipoId) {
        if (service.deleteEquipo(equipoId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


