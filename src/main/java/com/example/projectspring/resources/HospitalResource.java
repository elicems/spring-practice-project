package com.example.projectspring.resources;

import com.example.projectspring.entities.Hospital;
import com.example.projectspring.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Hospital> findById(@PathVariable Long id){
        Hospital obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Hospital> insert(@RequestBody Hospital obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Hospital> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Hospital> update(@PathVariable Long id,@RequestBody Hospital obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}
