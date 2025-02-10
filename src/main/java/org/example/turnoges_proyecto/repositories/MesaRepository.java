package org.example.turnoges_proyecto.repositories;


import org.example.turnoges_proyecto.models.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    Mesa findById(long id);
}