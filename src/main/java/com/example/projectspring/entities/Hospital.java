package com.example.projectspring.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

}
