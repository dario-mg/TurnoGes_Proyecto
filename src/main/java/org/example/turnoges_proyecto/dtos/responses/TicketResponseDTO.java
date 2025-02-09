package org.dmg.turnoges.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketResponseDTO {
    private String codigo;
    private String letraMesa;
    private LocalDateTime horaLlegada;
}