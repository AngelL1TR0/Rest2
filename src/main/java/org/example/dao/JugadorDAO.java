package org.example.dao;

import org.example.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorDAO extends JpaRepository<Jugador, Integer> {

}
