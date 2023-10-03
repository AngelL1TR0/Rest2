package org.example.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Patrocinador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class PatrocinadorDto implements Serializable {

    @NotNull
    @Positive
    private int id;

    @NotBlank
    private String nombre;

    public PatrocinadorDto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public PatrocinadorDto() {
    }

    public static PatrocinadorDto toDto(Patrocinador patrocinador){
        return new PatrocinadorDto(
                patrocinador.getId(),
                patrocinador.getNombre()
        );
    }

    public static Patrocinador toEntity(PatrocinadorDto patrocinadorDto){
        return new Patrocinador(
                patrocinadorDto.getId(),
                patrocinadorDto.getNombre()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

