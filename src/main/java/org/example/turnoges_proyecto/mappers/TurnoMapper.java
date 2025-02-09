package org.dmg.turnoges.mappers;


import org.dmg.turnoges.dtos.responses.TurnoResponseDTO;
import org.dmg.turnoges.models.Turno;
import org.springframework.stereotype.Component;

@Component
public class TurnoMapper {

    public TurnoResponseDTO toDTO(Turno turno) {
        TurnoResponseDTO dto = new TurnoResponseDTO();
        dto.setId(turno.getId());
        dto.setNombreEmpleado(turno.getEmpleado().getUsername());
        dto.setLetraMesa(String.valueOf(turno.getMesa().getLetra()));
        dto.setHoraInicio(turno.getHoraInicio());
        dto.setHoraFin(turno.getHoraFin());
        return dto;
    }
}