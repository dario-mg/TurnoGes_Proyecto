package org.example.turnoges_proyecto.mappers;


import org.example.turnoges_proyecto.dtos.responses.TurnoResponseDTO;
import org.example.turnoges_proyecto.models.Mesa;
import org.example.turnoges_proyecto.models.Turno;
import org.example.turnoges_proyecto.models.User;
import org.example.turnoges_proyecto.repositories.MesaRepository;
import org.example.turnoges_proyecto.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class TurnoMapper {

    private final UserRepository userRepository;
    private final MesaRepository mesaRepository;

    public TurnoMapper(UserRepository userRepository, MesaRepository mesaRepository) {
        this.userRepository = userRepository;
        this.mesaRepository = mesaRepository;
    }

    public TurnoResponseDTO toDTO(Turno turno) {
        TurnoResponseDTO dto = new TurnoResponseDTO();
        dto.setId(turno.getId());
        dto.setNombreEmpleado(turno.getEmpleado().getUsername());
        dto.setLetraMesa(String.valueOf(turno.getMesa().getLetra()));
        dto.setHoraInicio(turno.getHoraInicio());
        dto.setHoraFin(turno.getHoraFin());
        return dto;
    }

    public Turno toEntity(TurnoResponseDTO dto) {
        Turno turno = new Turno();
        turno.setId(dto.getId());
        turno.setHoraInicio(dto.getHoraInicio());

        User empleado = userRepository.findById(dto.getId())
                .orElseThrow(() -> new NoSuchElementException("Empleado no encontrado con nombre: " + dto.getId()));
        turno.setEmpleado(empleado);

        Mesa mesa = mesaRepository.findById(dto.getId())
                .orElseThrow(() -> new NoSuchElementException("Mesa no encontrada con letra: " + dto.getId()));
        turno.setMesa(mesa);

        return turno;
    }
}