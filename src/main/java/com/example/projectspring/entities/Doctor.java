package com.example.projectspring.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crm;

    public Doctor(Long id, String name, String crm) {
        this.id = id;
        this.name = name;
        this.crm = crm;
    }

    @OneToOne(mappedBy = "doctor",cascade = CascadeType.ALL)
    private Appointment appointment;
}
