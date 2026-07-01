package com.example.projectspring.services;

import com.example.projectspring.entities.Doctor;
import com.example.projectspring.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repository;

    public List<Doctor> findAll(){
        return repository.findAll();
    }
    public Doctor findById(Long id){
        Optional<Doctor> obj = repository.findById(id);
        return obj.get();
    }
}
