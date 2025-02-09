package org.dmg.turnoges.services;


import org.dmg.turnoges.dtos.responses.TicketResponseDTO;

import java.util.List;

public interface TicketService {
    List<TicketResponseDTO> getAllTickets();
    TicketResponseDTO getTicketById(Long id);
}