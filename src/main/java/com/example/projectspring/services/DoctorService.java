package com.example.projectspring.services;

import com.example.projectspring.entities.Doctor;
import com.example.projectspring.entities.Hospital;
import com.example.projectspring.repositories.DoctorRepository;
import com.example.projectspring.services.exceptions.DatabaseException;
import com.example.projectspring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Doctor insert(Doctor obj){
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
    public Doctor update(Long id,Doctor obj){
        try {
            Doctor entity = repository.getReferenceById(id);
            updateData(entity,obj);
            return repository.save(entity);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(Doctor entity,Doctor obj){
        entity.setName(obj.getName());
        entity.setCrm(obj.getCrm());
        entity.setConsultationPrice(obj.getConsultationPrice());
    }
}
