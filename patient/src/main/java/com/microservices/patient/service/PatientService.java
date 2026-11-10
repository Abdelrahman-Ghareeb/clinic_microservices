package com.microservices.patient.service;


import com.microservices.patient.dto.PatientDto;
import com.microservices.patient.dto.PatientDtoRequest;
import com.microservices.patient.dto.UpdatePatient;
import com.microservices.patient.mapper.PatientDTOMapper;
import com.microservices.patient.mapper.PatientMapper;
import com.microservices.patient.mapper.UpdatePatientMapper;
import com.microservices.patient.model.Patient;
import com.microservices.patient.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public List<PatientDto> patientList(){
       List<Patient> patients1= patientRepository.findAll();
        return patients1.stream().map(PatientDTOMapper::mapToDTO).collect(Collectors.toList());
    }

    public PatientDto findById(long id){
        Patient patient =patientRepository.findById(id).get();


        return PatientDto.builder().id(patient.getId()).age(patient.getAge()).name(patient.getName()).build();

    }

    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }
    public PatientDtoRequest savePatient(PatientDtoRequest patientDtoRequest){

       Patient patient= patientRepository.save(PatientMapper.mapToEntity(patientDtoRequest));
        return PatientMapper.mapToDTO(patient);
    }

    public UpdatePatient updatePatient(UpdatePatient patient) throws Exception {
       Patient patient2= patientRepository.save(UpdatePatientMapper.mapToEntity(patient));

        return UpdatePatientMapper.mapToDTO(patient2);
    }



    List<String> patients = Arrays.asList("John Doe", "Jane Smith", "Alice Johnson", "Bob Brown");

    public String getAllPatients(String name) {
        return patients.stream()
                .filter(patient -> patient.toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElse("Patient not found");
    }
}
