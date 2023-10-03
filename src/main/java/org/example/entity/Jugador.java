package org.example.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.example.controllers.dto.EquipoDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "jugador")
public class Jugador implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dorsal")
    private int dorsal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipo")
    @JsonBackReference
    private Equipo idEquipo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="jugador_patrocinador",
            joinColumns={@JoinColumn(name="id_jugador")},
            inverseJoinColumns={@JoinColumn(name="id_patrocinador")})
    @JsonBackReference
    private List<Patrocinador> patrocinadores;

    public Jugador(Integer id, String nombre, int dorsal, Equipo idEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.idEquipo = idEquipo;
    }

    public Jugador() {
    }

    public Jugador(int id, String nombre, int dorsal, EquipoDto idEquipo) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public List<Patrocinador> getPatrocinadores() {
        return patrocinadores;
    }

    public void setPatrocinadores(List<Patrocinador> patrocinadores) {
        this.patrocinadores = patrocinadores;
    }
}
