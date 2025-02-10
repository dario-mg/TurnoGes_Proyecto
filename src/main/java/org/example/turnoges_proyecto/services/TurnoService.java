package org.example.turnoges_proyecto.services;

import org.example.turnoges_proyecto.dtos.responses.TurnoResponseDTO;

import java.util.List;

public interface TurnoService {
    List<TurnoResponseDTO> getAllTurnos();
    TurnoResponseDTO getTurnoById(Long id);
}