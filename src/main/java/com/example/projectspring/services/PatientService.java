package com.example.projectspring.services;

import com.example.projectspring.entities.Patient;
import com.example.projectspring.repositories.PatientRepository;
import com.example.projectspring.services.exceptions.DatabaseException;
import com.example.projectspring.services.exceptions.ResourceNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public List<Patient> findAll(){
        return repository.findAll();
    }
    public Patient findById(Long id){
        Optional<Patient> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Patient insert(Patient obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
    public Patient update(Long id,Patient obj){
        try{
            Patient entity = repository.getReferenceById(id);
            updateData(entity,obj);
            return repository.save(entity);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(Patient entity,Patient obj){
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
    }
}
