package org.dmg.turnoges.services.Imp;


import lombok.RequiredArgsConstructor;
import org.dmg.turnoges.dtos.responses.MesaResponseDTO;
import org.dmg.turnoges.mappers.MesaMapper;
import org.dmg.turnoges.repositories.MesaRepository;
import org.dmg.turnoges.services.MesaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MesaServiceImpl implements MesaService {

    private final MesaRepository mesaRepository;
    private final MesaMapper mesaMapper;

    @Override
    public List<MesaResponseDTO> getAllMesas() {
        return mesaRepository.findAll().stream().map(mesaMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public MesaResponseDTO getMesaById(Long id) {
        return mesaRepository.findById(id).map(mesaMapper::toDTO).orElse(null);
    }
}