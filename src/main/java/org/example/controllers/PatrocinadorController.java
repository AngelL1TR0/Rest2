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
@RequestMapping("/patrocinadores")
public class PatrocinadorController {

    @Autowired
    private PatrocinadorService service;

    @GetMapping
    public ResponseEntity<List<PatrocinadorDto>> listPatrocinadores() {
        return ResponseEntity.ok(service.listPatrocinador());
    }

    @PostMapping
    public ResponseEntity<Void> addPatrocinador(@Valid @RequestBody PatrocinadorDto patrocinadorDto) {
        if (service.addPatrocinador(patrocinadorDto)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{patrocinadorId}")
    public ResponseEntity<Patrocinador> updatePatrocinador(
            @PathVariable("patrocinadorId") int patrocinadorId,
            @Valid @RequestBody PatrocinadorDto patrocinadorDto
    ) {
        Patrocinador patrocinador = service.findPatrocinador(patrocinadorId);
        if (patrocinador != null) {
            service.updatePatrocinador(patrocinador, patrocinadorDto);
            return ResponseEntity.ok(patrocinador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{patrocinadorId}")
    public ResponseEntity<Void> deletePatrocinador(@PathVariable("patrocinadorId") int patrocinadorId) {
        if (service.deletePatrocinador(patrocinadorId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
