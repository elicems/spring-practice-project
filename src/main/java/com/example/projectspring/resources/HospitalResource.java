package com.example.projectspring.resources;

import com.example.projectspring.entities.Hospital;
import com.example.projectspring.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hospitals")
public class HospitalResource {
    @Autowired
    private HospitalService service;

    @GetMapping
    public ResponseEntity<List<Hospital>> findAll(){
        List<Hospital> list = service.FindAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Hospital> findById(Long id){
        Hospital obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
