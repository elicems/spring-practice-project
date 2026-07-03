package com.example.projectspring.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Instant appointmentDate;

    @OneToOne
    @MapsId
    private Hospital hospital;

    @OneToOne
    @MapsId
    private Doctor doctor;
}
