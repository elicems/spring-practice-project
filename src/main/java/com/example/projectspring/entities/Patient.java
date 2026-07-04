package com.example.projectspring.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String numberCard;
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment = new ArrayList<>();

    public Patient(Long id,String name,String numberCard,String phone){
        this.id = id;
        this.name = name;
        this.numberCard = numberCard;
        this.phone = phone;
    }
}
