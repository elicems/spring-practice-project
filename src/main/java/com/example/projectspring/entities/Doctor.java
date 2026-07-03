package com.example.projectspring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crm;

    @OneToOne(mappedBy = "doctor",cascade = CascadeType.ALL)
    private Appointment appointment;
}
