package org.dmg.turnoges.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TurnoResponseDTO {
    private Long id;
    private String nombreEmpleado;
    private String letraMesa;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
}