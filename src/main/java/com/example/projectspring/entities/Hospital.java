package com.example.projectspring.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    public Hospital(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @OneToOne(mappedBy = "hospital",cascade = CascadeType.ALL)
    private Appointment appointment;
}
