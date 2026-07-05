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
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Double taxService;

    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    private List<Appointment> appointment = new ArrayList<>();

    public Hospital(Long id, String name, String address,Double taxService) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.taxService = taxService;
    }
}
