package org.dmg.turnoges.mappers;


import org.dmg.turnoges.dtos.responses.MesaResponseDTO;
import org.dmg.turnoges.models.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaResponseDTO toDTO(Mesa mesa) {
        MesaResponseDTO dto = new MesaResponseDTO();
        dto.setLetra(String.valueOf(mesa.getLetra()));
        dto.setNombreEmpleado(mesa.getEmpleado() != null ? mesa.getEmpleado().getUsername() : null);
        return dto;
    }
}