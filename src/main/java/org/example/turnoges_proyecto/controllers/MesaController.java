package org.example.turnoges_proyecto.controllers;

import lombok.RequiredArgsConstructor;
import org.example.turnoges_proyecto.dtos.responses.MesaResponseDTO;
import org.example.turnoges_proyecto.services.MesaService;
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
        List<MesaResponseDTO> mesas = mesaService.getAllMesas();
        if (mesas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mesas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaResponseDTO> getMesaById(@PathVariable Long id) {
        MesaResponseDTO mesa = mesaService.getMesaById(id);
        if (mesa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mesa);
    }
}