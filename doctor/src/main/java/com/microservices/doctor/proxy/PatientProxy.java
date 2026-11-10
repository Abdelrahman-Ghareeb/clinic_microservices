package com.microservices.doctor.proxy;

import com.microservices.doctor.dto.PatientDto;
import com.microservices.doctor.dto.PatientDtoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "patient-service")
public interface PatientProxy {

    @GetMapping("/{name}")
    public String getPatentName(@PathVariable String name);

    @GetMapping("/patient/findById/{id}")
    public PatientDto getPatient(@PathVariable long id) ;

    @PostMapping("/patient/add")
    public PatientDtoRequest addPatient(@RequestBody PatientDtoRequest patient);

    @GetMapping("/list")
    public List<PatientDto> listAllPatients();
}
