package org.example.turnoges_proyecto.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.turnoges_proyecto.dtos.responses.LoginDTO;
import org.example.turnoges_proyecto.dtos.responses.RegisterDTO;
import org.example.turnoges_proyecto.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("turnoges")
@RequiredArgsConstructor
public class AuthRestController {
    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.register(dto));
    }
}


