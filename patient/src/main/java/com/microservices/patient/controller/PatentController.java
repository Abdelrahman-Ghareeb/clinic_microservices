package com.microservices.patient.controller;


import com.microservices.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatentController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{name}")
    public String getPatentName(@PathVariable String name) {
        return  patientService.getAllPatients(name);
    }
}
