package com.example.projectspring.services;

import com.example.projectspring.entities.Hospital;
import com.example.projectspring.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository repository;

    public List<Hospital> FindAll(){
        return repository.findAll();
    }
    public Hospital findById(Long id){
        Optional<Hospital> obj = repository.findById(id);
        return obj.get();
    }
}
