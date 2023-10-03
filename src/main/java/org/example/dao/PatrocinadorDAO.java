package org.example.dao;

import org.example.entity.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatrocinadorDAO extends JpaRepository<Patrocinador, Integer> {

}
