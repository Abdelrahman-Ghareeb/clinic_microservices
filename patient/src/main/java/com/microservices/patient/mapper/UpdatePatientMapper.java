package com.microservices.patient.mapper;

import com.microservices.patient.dto.PatientDtoRequest;
import com.microservices.patient.dto.UpdatePatient;
import com.microservices.patient.model.Patient;

public class UpdatePatientMapper {

    public static Patient mapToEntity(UpdatePatient request){
        return Patient.builder().id(request.getId()).age(request.getAge()).name(request.getName()).build();
    }

    public static UpdatePatient mapToDTO(Patient patient){
        return UpdatePatient.builder().id(patient.getId()).age(patient.getAge()).name(patient.getName()).build();
    }
}
