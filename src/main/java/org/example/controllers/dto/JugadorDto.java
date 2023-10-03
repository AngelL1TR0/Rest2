package org.example.controllers.dto;

import org.example.entity.Equipo;
import org.example.entity.Jugador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class JugadorDto implements Serializable {

    @NotNull
    @Positive
    private int id;

    @NotBlank
    private String nombre;

    @NotNull
    @Positive
    private int dorsal;

    @NotNull
    private EquipoDto idEquipo;

    public JugadorDto(int id, String nombre, int dorsal, EquipoDto idEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.idEquipo = idEquipo;
    }

    public JugadorDto() {
    }

    public static JugadorDto toDto(Jugador jugador) {
        return new JugadorDto(
                jugador.getId(),
                jugador.getNombre(),
                jugador.getDorsal(),
                EquipoDto.toDto(jugador.getIdEquipo())
        );
    }

    public static Jugador toEntity(JugadorDto jugadorDto) {
        return new Jugador(
                jugadorDto.getId(),
                jugadorDto.getNombre(),
                jugadorDto.getDorsal(),
                EquipoDto.toEntity(jugadorDto.getIdEquipo())
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

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public EquipoDto getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(EquipoDto idEquipo) {
        this.idEquipo = idEquipo;
    }
}