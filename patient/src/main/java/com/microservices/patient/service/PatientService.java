package com.microservices.patient.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PatientService {

    List<String> patients = Arrays.asList("John Doe", "Jane Smith", "Alice Johnson", "Bob Brown");

    public String getAllPatients(String name) {
        return patients.stream()
                .filter(patient -> patient.toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElse("Patient not found");
    }
}
