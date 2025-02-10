package org.example.turnoges_proyecto.services;


import org.example.turnoges_proyecto.dtos.responses.TicketResponseDTO;

import java.util.List;

public interface TicketService {
    List<TicketResponseDTO> getAllTickets();
    TicketResponseDTO getTicketById(Long id);
}