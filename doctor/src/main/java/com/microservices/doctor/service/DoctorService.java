package com.microservices.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorService {


    @Autowired
    private RestTemplate restTemplate;

    public String getPatient(String name) {
        // Assuming the doctor microservice is running on localhost:8081

        String url = "http://localhost:8881/" + name;
        return restTemplate.getForObject(url, String.class);
    }
}
