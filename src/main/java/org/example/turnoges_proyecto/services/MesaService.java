package org.example.turnoges_proyecto.services;



import org.example.turnoges_proyecto.dtos.responses.MesaResponseDTO;

import java.util.List;

public interface MesaService {
    List<MesaResponseDTO> getAllMesas();
    MesaResponseDTO getMesaById(Long id);
}