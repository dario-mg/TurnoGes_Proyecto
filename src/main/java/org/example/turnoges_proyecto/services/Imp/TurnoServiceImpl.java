package org.dmg.turnoges.services.Imp;


import lombok.RequiredArgsConstructor;
import org.dmg.turnoges.dtos.responses.TurnoResponseDTO;
import org.dmg.turnoges.mappers.TurnoMapper;
import org.dmg.turnoges.models.Turno;
import org.dmg.turnoges.repositories.TurnoRepository;
import org.dmg.turnoges.services.TurnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurnoServiceImpl implements TurnoService {

    private final TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;

    @Override
    public List<TurnoResponseDTO> getAllTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        return turnos.stream().map(
                turnoMapper::toDTO
        ).toList();
    }

    @Override
    public TurnoResponseDTO getTurnoById(Long id) {
        return turnoRepository.findById(id).map(turnoMapper::toDTO).orElse(null);
    }
}