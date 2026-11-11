package com.microservices.patient.controller;


import com.microservices.patient.dto.PatientDto;
import com.microservices.patient.dto.PatientDtoRequest;
import com.microservices.patient.dto.UpdatePatient;
import com.microservices.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{name}")
    public String getPatentName(@PathVariable String name) {
        return  patientService.getAllPatients(name);
    }


        @PostMapping("/add")
        public PatientDtoRequest addPatient(@RequestBody PatientDtoRequest patient){
            return patientService.savePatient(patient);
        }

    @PutMapping
    public UpdatePatient updatePatient(@RequestBody UpdatePatient patient) throws Exception {
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable long id) throws Exception {
         patientService.deletePatient(id);
    }

    @GetMapping("/findById/{id}")
    public PatientDto getPatient(@PathVariable long id) throws Exception {
       return patientService.findById(id);
    }

    @GetMapping("/list")
    public List<PatientDto>listAllPatients(){
        return patientService.patientList();
    }
}
