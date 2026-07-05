package com.example.projectspring.services;

import com.example.projectspring.entities.Appointment;
import com.example.projectspring.repositories.AppointmentRepository;
import com.example.projectspring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    public List<Appointment> findAll(){
        return repository.findAll();
    }
    public Appointment findById(Long id){
        Optional<Appointment> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
