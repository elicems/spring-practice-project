package com.example.projectspring.resources;

import com.example.projectspring.entities.Patient;
import com.example.projectspring.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/patients")
public class PatientResource {
    @Autowired
    private PatientService service;

    @GetMapping
    public ResponseEntity<List<Patient>> findAll(){
        List<Patient> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id){
        Patient obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
