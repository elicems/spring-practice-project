package com.example.projectspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private Double consultationPrice;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Appointment> appointment = new ArrayList<>();

    public Doctor(Long id, String name, String crm,Double consultationPrice) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.consultationPrice = consultationPrice;
    }
}
