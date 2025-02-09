package org.dmg.turnoges.services;

import org.dmg.turnoges.dtos.responses.TurnoResponseDTO;

import java.util.List;

public interface TurnoService {
    List<TurnoResponseDTO> getAllTurnos();
    TurnoResponseDTO getTurnoById(Long id);
}