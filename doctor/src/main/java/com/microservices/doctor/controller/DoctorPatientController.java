package com.microservices.doctor.controller;

import com.microservices.doctor.dto.PatientDto;
import com.microservices.doctor.dto.PatientDtoRequest;
import com.microservices.doctor.proxy.PatientProxy;
import com.microservices.doctor.service.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorPatientController {

    @Autowired
    private DoctorPatientService doctorPatientService;



    @GetMapping("/doctor-patient/{name}")
    public String getDoctorPatient(@PathVariable String name) {


        return doctorPatientService.getPatient(name);
    }

    @GetMapping("/doctor-patient-by-id/{id}")
    public PatientDto getDoctorPatientById(@PathVariable long id) {


        return doctorPatientService.getPatientById(id);
    }

    @GetMapping("/doctor-patient/list")
    public List<PatientDto> listAllPatients(){
        return doctorPatientService.findAllPatients();

    }

    @PostMapping("/add")
    public PatientDtoRequest addPatient(@RequestBody PatientDtoRequest patient){
        return doctorPatientService.savePatient(patient);
    }

}
