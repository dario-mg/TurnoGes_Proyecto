package org.dmg.turnoges.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 5, unique = true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "mesa_id", referencedColumnName = "id", nullable = true)
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = true)
    private User cliente;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime horaLlegada;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime horaAtendido;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime horaSalida;
}