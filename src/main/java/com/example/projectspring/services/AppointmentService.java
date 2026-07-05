package com.example.projectspring.services;

import com.example.projectspring.entities.Appointment;
import com.example.projectspring.repositories.AppointmentRepository;
import com.example.projectspring.services.exceptions.DatabaseException;
import com.example.projectspring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public Appointment insert(Appointment obj){
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
    public Appointment update(Long id,Appointment obj){
        try {
            Appointment entity = repository.getReferenceById(id);
            updateData(entity,obj);
            return repository.save(entity);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(Appointment entity,Appointment obj){
        entity.setAppointmentDate(obj.getAppointmentDate());
    }

}
