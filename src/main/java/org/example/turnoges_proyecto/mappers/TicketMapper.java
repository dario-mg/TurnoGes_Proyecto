package org.example.turnoges_proyecto.mappers;


import org.example.turnoges_proyecto.dtos.responses.TicketResponseDTO;
import org.example.turnoges_proyecto.models.Mesa;
import org.example.turnoges_proyecto.models.Ticket;
import org.example.turnoges_proyecto.repositories.MesaRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class TicketMapper {

    private final MesaRepository mesaRepository;

    public TicketMapper(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public TicketResponseDTO toDTO(Ticket ticket) {
        TicketResponseDTO dto = new TicketResponseDTO();
        dto.setCodigo(ticket.getCodigo());
        dto.setLetraMesa(String.valueOf(ticket.getMesa().getLetra()));
        dto.setHoraLlegada(ticket.getHoraLlegada());
        return dto;
    }

    public Ticket toEntity(TicketResponseDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setCodigo(dto.getCodigo());

        Mesa mesa = mesaRepository.findById(dto.getId())
                .orElseThrow(() -> new NoSuchElementException("Mesa no encontrada con letra: " + dto.getId()));
        ticket.setMesa(mesa);
        ticket.setHoraLlegada(dto.getHoraLlegada());
        return ticket;
    }
}