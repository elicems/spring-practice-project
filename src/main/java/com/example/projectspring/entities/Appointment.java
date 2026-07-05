package com.example.projectspring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT")
    private Instant appointmentDate;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment(Long id, Patient patient, Instant appointmentDate, Hospital hospital, Doctor doctor) {
        this.id = id;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.hospital = hospital;
        this.doctor = doctor;
    }
    public Double getSubTotal(){
        Double taxService = this.doctor.getConsultationPrice() * (this.hospital.getTaxService()/100);
        return this.doctor.getConsultationPrice() + taxService;
    }
    public Double getTotal(Patient p){
        Double sum = 0.0;
        for (Appointment a : p.getAppointment()){
            sum += a.getSubTotal();
        }
        return sum;
    }
}
