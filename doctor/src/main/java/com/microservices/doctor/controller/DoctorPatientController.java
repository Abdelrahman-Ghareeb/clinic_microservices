package com.microservices.doctor.controller;

import com.microservices.doctor.proxy.PatientProxy;
import com.microservices.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;
import java.util.UUID;

@RestController
public class DoctorPatientController {

    @Autowired
    private  DoctorService doctorPatientService;

    @Autowired
    private PatientProxy patientProxy;

    @GetMapping("/doctor-patient/{name}")
    public String getDoctorPatient(@PathVariable String name) {


        return patientProxy.getPatentName(name);
    }
}
