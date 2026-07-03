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

    @OneToMany(mappedBy = "patient")
    private Patient patient;

    private Instant appointmentDate;
    private Hospital hospital;
    private Doctor doctor;
}
