package org.example.turnoges_proyecto.services.Imp;


import lombok.RequiredArgsConstructor;
import org.example.turnoges_proyecto.dtos.responses.TicketResponseDTO;
import org.example.turnoges_proyecto.mappers.TicketMapper;
import org.example.turnoges_proyecto.models.Ticket;
import org.example.turnoges_proyecto.repositories.TicketRepository;
import org.example.turnoges_proyecto.services.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public List<TicketResponseDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(
                ticketMapper::toDTO
        ).toList();
    }

    @Override
    public TicketResponseDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        return ticketMapper.toDTO(ticket);
    }
}