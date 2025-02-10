package org.example.turnoges_proyecto.mappers;


import org.example.turnoges_proyecto.dtos.responses.MesaResponseDTO;
import org.example.turnoges_proyecto.models.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaResponseDTO toDTO(Mesa mesa) {
        MesaResponseDTO dto = new MesaResponseDTO();
        dto.setLetra(String.valueOf(mesa.getLetra()));
        dto.setNombreEmpleado(mesa.getEmpleado() != null ? mesa.getEmpleado().getUsername() : null);
        return dto;
    }

//    public Mesa toEntity(MesaResponseDTO dto) {
//        Mesa mesa = new Mesa();
//        mesa.setLetra(dto.getLetra());
//        return mesa;
//    }
}