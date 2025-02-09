package org.dmg.turnoges.services;


import org.dmg.turnoges.dtos.responses.MesaResponseDTO;

import java.util.List;

public interface MesaService {
    List<MesaResponseDTO> getAllMesas();
    MesaResponseDTO getMesaById(Long id);
}