package com.example.projectspring.resources;

import com.example.projectspring.entities.Doctor;
import com.example.projectspring.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorResource {
    @Autowired
    private DoctorService service;

    @GetMapping
    public ResponseEntity<List<Doctor>> findAll(){
        List<Doctor> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id){
        Doctor obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
