package com.microservices.patient.mapper;

import com.microservices.patient.dto.PatientDto;
import com.microservices.patient.dto.PatientDtoRequest;
import com.microservices.patient.model.Patient;

public class PatientDTOMapper {

    public static Patient mapToEntity(PatientDto request){
        return Patient.builder().id(request.getId()).age(request.getAge()).name(request.getName()).build();
    }

    public static PatientDto mapToDTO(Patient patient){
        return PatientDto.builder().id(patient.getId()).age(patient.getAge()).name(patient.getName()).build();
    }
}
