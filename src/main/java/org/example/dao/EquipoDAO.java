package org.example.dao;

import org.example.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoDAO extends JpaRepository<Equipo, Integer> {
}
