package org.example.turnoges_proyecto.services.Imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.turnoges_proyecto.dtos.responses.AuthDTO;
import org.example.turnoges_proyecto.dtos.responses.LoginDTO;
import org.example.turnoges_proyecto.dtos.responses.RegisterDTO;
import org.example.turnoges_proyecto.models.User;
import org.example.turnoges_proyecto.repositories.UserRepository;
import org.example.turnoges_proyecto.security.JwtUtil;
import org.example.turnoges_proyecto.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthDTO login(LoginDTO login) throws Exception {
        try {
            authenticate(login.getUsername(), login.getPassword());

            User user = userRepository.findByUsername(login.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            String token = jwtUtil.generateToken(user);
            return new AuthDTO(token);
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            System.out.println(e.getMessage());
            throw new BadCredentialsException("Incorrect username or password");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public AuthDTO register(RegisterDTO register) throws Exception {
        try {
            User user = createUserFromRegistration(register);
            User existingUser = userRepository.findByUsername(user.getUsername()).orElse(null);
            if (existingUser != null) {
                throw new Exception("Username already exists");
            }

            user = userRepository.save(user);

            String token = jwtUtil.generateToken(user);
            return new AuthDTO(token);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }


    private User createUserFromRegistration(RegisterDTO register) {
        User user = new User();
        user.setUsername(register.getUsername());
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        user.setRole(User.UserRole.valueOf(register.getRol()));

        return user;
    }
}

