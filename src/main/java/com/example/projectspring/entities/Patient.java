package com.example.projectspring.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String numberCard;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Appointment appointment;
}
