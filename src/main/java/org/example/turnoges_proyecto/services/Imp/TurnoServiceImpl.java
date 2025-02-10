package org.example.turnoges_proyecto.services.Imp;



import lombok.RequiredArgsConstructor;
import org.example.turnoges_proyecto.dtos.responses.TurnoResponseDTO;
import org.example.turnoges_proyecto.mappers.TurnoMapper;
import org.example.turnoges_proyecto.models.Turno;
import org.example.turnoges_proyecto.repositories.TurnoRepository;
import org.example.turnoges_proyecto.services.TurnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Turno turno = turnoRepository.findById(id).orElse(null);
        return turnoMapper.toDTO(turno);
    }
}