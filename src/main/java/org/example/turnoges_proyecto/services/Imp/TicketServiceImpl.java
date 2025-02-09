package org.dmg.turnoges.services.Imp;

import lombok.RequiredArgsConstructor;
import org.dmg.turnoges.dtos.responses.TicketResponseDTO;
import org.dmg.turnoges.mappers.TicketMapper;
import org.dmg.turnoges.repositories.TicketRepository;
import org.dmg.turnoges.services.TicketService;
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
        return ticketRepository.findAll().stream().map(ticketMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public TicketResponseDTO getTicketById(Long id) {
        return ticketRepository.findById(id).map(ticketMapper::toDTO).orElse(null);
    }
}