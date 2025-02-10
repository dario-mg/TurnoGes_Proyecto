package org.example.turnoges_proyecto.repositories;

import org.example.turnoges_proyecto.models.Cola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaRepository extends JpaRepository<Cola, Long> {
}