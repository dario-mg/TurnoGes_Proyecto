package org.example.turnoges_proyecto.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketResponseDTO {
    private Long id;
    private String codigo;
    private String letraMesa;
    private LocalDateTime horaLlegada;
}