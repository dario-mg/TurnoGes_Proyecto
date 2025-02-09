package org.dmg.turnoges.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "mesas", uniqueConstraints = {@UniqueConstraint(columnNames = {"empleado_id"})})
@Data
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1)
    private char letra;

    @ManyToOne
    @JoinColumn(name = "empleado_id", referencedColumnName = "id", nullable = true)
    private User empleado;

    @OneToMany(mappedBy = "mesa")
    private Set<Ticket> tickets;

    @OneToMany(mappedBy = "mesa")
    private Set<Turno> turnos;
}