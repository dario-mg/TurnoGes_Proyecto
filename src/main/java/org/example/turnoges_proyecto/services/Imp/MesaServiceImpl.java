package org.example.turnoges_proyecto.services.Imp;


import lombok.RequiredArgsConstructor;
import org.example.turnoges_proyecto.dtos.responses.MesaResponseDTO;
import org.example.turnoges_proyecto.mappers.MesaMapper;
import org.example.turnoges_proyecto.models.Mesa;
import org.example.turnoges_proyecto.repositories.MesaRepository;
import org.example.turnoges_proyecto.services.MesaService;
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
        List<Mesa> mesas = mesaRepository.findAll();
        return mesas.stream().map(
                mesaMapper::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public MesaResponseDTO getMesaById(Long id) {
        Mesa mesa = mesaRepository.findById(id).orElse(null);
        return mesaMapper.toDTO(mesa);
    }
}