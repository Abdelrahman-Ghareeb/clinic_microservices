package com.microservices.doctor.service;

import com.microservices.doctor.dto.PatientDto;
import com.microservices.doctor.dto.PatientDtoRequest;
import com.microservices.doctor.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DoctorPatientService {


    @Autowired
    private PatientProxy proxy;

    @Autowired
    private RestTemplate restTemplate;

    public String getPatient(String name) {
        // Assuming the doctor microservice is running on localhost:8081

        String url = "http://localhost:8881/" + name;
        return restTemplate.getForObject(url, String.class);
    }

    public PatientDto getPatientById(long id){
        return proxy.getPatient(id);
    }

    public PatientDtoRequest savePatient(PatientDtoRequest patient) {
        return proxy.addPatient(patient);
    }

    public List<PatientDto> findAllPatients() {
        return proxy.listAllPatients();
    }
}
