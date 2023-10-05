package org.example.controllers.dto;

import org.example.entity.Equipo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;


public class EquipoDto implements Serializable {

    @NotNull
    @Positive
    private int id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String ciudad;

    public EquipoDto(int id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public EquipoDto() {
    }

    public static EquipoDto toDto(Equipo equipo){
        return new EquipoDto(
                equipo.getId(),
                equipo.getNombre(),
                equipo.getCiudad()
        );
    }

    public static Equipo toEntity(EquipoDto equipoDto){
        return new Equipo(
                equipoDto.getId(),
                equipoDto.getNombre(),
                equipoDto.getCiudad()
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
