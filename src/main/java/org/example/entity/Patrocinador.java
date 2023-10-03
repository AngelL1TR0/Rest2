package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "patrocinador")
public class Patrocinador implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name ="nombre")
    private String nombre;

    @ManyToMany(mappedBy = "patrocinadores")
    private List<Jugador> jugadores;

    public Patrocinador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Patrocinador() {
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
