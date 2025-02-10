package org.example.turnoges_proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cola", uniqueConstraints = {@UniqueConstraint(columnNames = {"ticket_id", "mesa_id"})})
@Data
public class Cola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "mesa_id", referencedColumnName = "id", nullable = false)
    private Mesa mesa;

    @Column(nullable = false)
    private int posicion;
}