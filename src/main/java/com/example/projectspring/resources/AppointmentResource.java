package com.example.projectspring.resources;

import com.example.projectspring.entities.Appointment;
import com.example.projectspring.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentResource {
    @Autowired
    private AppointmentService service;

    @GetMapping
    public ResponseEntity<List<Appointment>> findAll(){
        List<Appointment> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Appointment> findById(Long id){
        Appointment obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
