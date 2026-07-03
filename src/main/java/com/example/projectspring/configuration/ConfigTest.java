package com.example.projectspring.configuration;

import com.example.projectspring.entities.Patient;
import com.example.projectspring.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Patient p1 = new Patient(null,"Ze reua", "1220002", "11977495644");
        Patient p2 = new Patient(null,"POrra da silva", "787888", "11988877666");

        patientRepository.saveAll(Arrays.asList(p1,p2));

    }
}
