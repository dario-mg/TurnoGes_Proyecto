package org.dmg.turnoges.mappers;


import org.dmg.turnoges.dtos.responses.TicketResponseDTO;
import org.dmg.turnoges.models.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketResponseDTO toDTO(Ticket ticket) {
        TicketResponseDTO dto = new TicketResponseDTO();
        dto.setCodigo(ticket.getCodigo());
        dto.setLetraMesa(String.valueOf(ticket.getMesa().getLetra()));
        dto.setHoraLlegada(ticket.getHoraLlegada());
        return dto;
    }
}