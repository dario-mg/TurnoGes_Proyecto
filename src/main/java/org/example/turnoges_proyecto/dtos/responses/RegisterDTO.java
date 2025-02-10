package org.example.turnoges_proyecto.dtos.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterDTO {
    @NotNull(message = "El nombre es obligatorio")
    @NotBlank(message = "El nombre no puede estar vacío")
    String username;

    @NotNull(message = "La contraseña es obligatoria")
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&!+=])(?=\\S+$).{8,20}$",
            message = "La contraseña debe tener entre 10 y 20 caracteres, incluir números, una letra mayúscula, una minúscula y un carácter especial @#$%^&+!=.")
    private String password;

    @NotNull(message = "El nombre es obligatorio")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Pattern(regexp = "administrador|empleado|cliente", message = "El rol debe ser 'administrador', 'empleado' o 'cliente'")
    String rol;
}

