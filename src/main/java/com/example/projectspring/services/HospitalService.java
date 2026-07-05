package com.example.projectspring.services;

import com.example.projectspring.entities.Hospital;
import com.example.projectspring.repositories.HospitalRepository;
import com.example.projectspring.services.exceptions.DatabaseException;
import com.example.projectspring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Hospital insert(Hospital obj){
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
    public Hospital update(Long id,Hospital obj){
        try{
            Hospital entity = repository.getReferenceById(id);
            updateData(entity,obj);
            return repository.save(entity);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(Hospital entity,Hospital obj){
        entity.setName(obj.getName());
        entity.setAddress(obj.getAddress());
        entity.setTaxService(obj.getTaxService());
    }
}
