package org.example.controllers.dto;

import org.example.entity.Equipo;
import org.example.entity.Jugador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class JugadorEquipoDto implements Serializable {

    @NotBlank
    private Integer jugadorId;

    @NotBlank
    private String jugadorNombre;
    @NotNull
    @Positive
    private int jugadorDorsal;

    @NotNull
    @Positive
    private Integer equipoId;

    @NotBlank
    private String equipoNombre;

    @NotBlank
    private String equipoCiudad;

    public JugadorEquipoDto() {
    }

    public JugadorEquipoDto(Integer jugadorId, String jugadorNombre, int jugadorDorsal, Integer equipoId, String equipoNombre, String equipoCiudad) {
        this.jugadorId = jugadorId;
        this.jugadorNombre = jugadorNombre;
        this.jugadorDorsal = jugadorDorsal;
        this.equipoId = equipoId;
        this.equipoNombre = equipoNombre;
        this.equipoCiudad = equipoCiudad;
    }

    public Integer getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(Integer jugadorId) {
        this.jugadorId = jugadorId;
    }

    public String getJugadorNombre() {
        return jugadorNombre;
    }

    public void setJugadorNombre(String jugadorNombre) {
        this.jugadorNombre = jugadorNombre;
    }

    public int getJugadorDorsal() {
        return jugadorDorsal;
    }

    public void setJugadorDorsal(int jugadorDorsal) {
        this.jugadorDorsal = jugadorDorsal;
    }

    public Integer getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Integer equipoId) {
        this.equipoId = equipoId;
    }

    public String getEquipoNombre() {
        return equipoNombre;
    }

    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }

    public String getEquipoCiudad() {
        return equipoCiudad;
    }

    public void setEquipoCiudad(String equipoCiudad) {
        this.equipoCiudad = equipoCiudad;
    }

    // Getters y setters (omitiendo para brevedad)

    public static JugadorEquipoDto toDto(Jugador jugador, Equipo equipo) {
        return new JugadorEquipoDto(
                jugador.getId(),
                jugador.getNombre(),
                jugador.getDorsal(),
                equipo.getId(),
                equipo.getNombre(),
                equipo.getCiudad()
        );
    }

    public static Jugador toEntity(JugadorEquipoDto dto, Equipo equipo) {
        Jugador jugador = new Jugador();
        jugador.setId(dto.getJugadorId());
        jugador.setNombre(dto.getJugadorNombre());
        jugador.setDorsal(dto.getJugadorDorsal());
        jugador.setIdEquipo(equipo);
        return jugador;
    }
}
