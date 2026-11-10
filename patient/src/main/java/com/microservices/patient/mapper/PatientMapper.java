package com.microservices.patient.mapper;

import com.microservices.patient.dto.PatientDtoRequest;
import com.microservices.patient.model.Patient;

public class PatientMapper {


    public static Patient mapToEntity(PatientDtoRequest request){
        return Patient.builder().age(request.getAge()).name(request.getName()).build();
    }

    public static PatientDtoRequest mapToDTO(Patient patient){
        return PatientDtoRequest.builder().age(patient.getAge()).name(patient.getName()).build();
    }
}
