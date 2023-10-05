package org.example.controllers;

import org.example.controllers.dto.PatrocinadorDto;
import org.example.entity.Patrocinador;
import org.example.service.PatrocinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
public class PatrocinadorController {

    @Autowired
    private PatrocinadorService patrocinadorService;
    @GetMapping(path = "/patrocinadores")
    public ResponseEntity<List<PatrocinadorDto>> list() {
        return ResponseEntity.ok(patrocinadorService.listPatrocinador()
                .stream()
                .map(PatrocinadorDto::toDto)
                .collect(Collectors.toList())
        );
    }


    @PostMapping(path = "/patrocinadores")
    public ResponseEntity<Void> add(
            @Valid @RequestBody PatrocinadorDto patrocinadorDto
    ) { if (patrocinadorService.addPatrocinador(patrocinadorDto.toEntity(patrocinadorDto))) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    }

    @PutMapping(path = "/patrocinadores/{patrocinadorId}")
    public ResponseEntity<Patrocinador> update(
            @PathVariable("patrocinadorId") int patrocinadorId,
            @Valid @RequestBody PatrocinadorDto patrocinador
    ) {
        Patrocinador s = patrocinadorService.findPatrocinador(patrocinadorId);
        if (s != null) {
            s.setId(patrocinador.getId());
            s.setNombre(patrocinador.getNombre());
            patrocinadorService.addPatrocinador(s);
            return ResponseEntity.ok().body(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/patrocinadores/{patrocinadorId}")
    public ResponseEntity<Void> delete(
            @PathVariable("patrocinadorId") int patrocinadorId) {
        if (patrocinadorService.deletePatrocinador(patrocinadorId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
