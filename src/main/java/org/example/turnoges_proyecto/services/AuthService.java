package org.example.turnoges_proyecto.services;

import org.example.turnoges_proyecto.dtos.responses.AuthDTO;
import org.example.turnoges_proyecto.dtos.responses.LoginDTO;
import org.example.turnoges_proyecto.dtos.responses.RegisterDTO;

public interface AuthService {
    AuthDTO login(LoginDTO login) throws Exception;
    AuthDTO register(RegisterDTO register) throws Exception;
}
