package org.dmg.turnoges.controllers;

import lombok.RequiredArgsConstructor;
import org.dmg.turnoges.dtos.responses.MesaResponseDTO;
import org.dmg.turnoges.services.MesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turnoges/mesas")
@RequiredArgsConstructor
public class MesaController {

    private final MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<MesaResponseDTO>> getAllMesas() {
        return ResponseEntity.ok(mesaService.getAllMesas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaResponseDTO> getMesaById(@PathVariable Long id) {
        MesaResponseDTO mesa = mesaService.getMesaById(id);
        return mesa != null ? ResponseEntity.ok(mesa) : ResponseEntity.notFound().build();
    }
}