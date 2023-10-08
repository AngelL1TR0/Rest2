package org.example.service;

import org.example.controllers.dto.PatrocinadorDto;
import org.example.dao.PatrocinadorDAO;
import org.example.entity.Jugador;
import org.example.entity.Patrocinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatrocinadorService {

    @Autowired
    private PatrocinadorDAO patrocinadorDAO;

    public List<PatrocinadorDto> listPatrocinador() {
        List<Patrocinador> patrocinadores = patrocinadorDAO.findAll();
        return patrocinadores.stream().map(PatrocinadorDto::toDto).collect(Collectors.toList());
    }

    public boolean addPatrocinador(PatrocinadorDto patrocinadorDto) {
        try {
            patrocinadorDAO.save(patrocinadorDto.toEntity(patrocinadorDto));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Patrocinador findPatrocinador(int patrocinadorId) {
        return patrocinadorDAO.findById(patrocinadorId).orElse(null);
    }

    public void updatePatrocinador(Patrocinador patrocinador, PatrocinadorDto patrocinadorDto) {
        patrocinador.setId(patrocinadorDto.getId());
        patrocinador.setNombre(patrocinadorDto.getNombre());
        patrocinadorDAO.save(patrocinador);
    }

    public boolean deletePatrocinador(int patrocinadorId) {
        try {
            patrocinadorDAO.deleteById(patrocinadorId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

