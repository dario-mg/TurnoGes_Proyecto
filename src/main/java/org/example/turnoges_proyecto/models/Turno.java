package org.dmg.turnoges.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@Data
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id", referencedColumnName = "id", nullable = false)
    private User empleado;

    @ManyToOne
    @JoinColumn(name = "mesa_id", referencedColumnName = "id", nullable = false)
    private Mesa mesa;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime horaInicio;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime horaFin;
}