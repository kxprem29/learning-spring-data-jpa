package com.kxprem.hospitalManagement.service;

import com.kxprem.hospitalManagement.entity.Patient;
import com.kxprem.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientbyId(Long id){
        Patient p1 =patientRepository.findById(id).orElseThrow();

        Patient p2=patientRepository.findById(id).orElseThrow();

        p1.setEmail("prem_ucs184@ug.nita.ac.in");
        return p1;
    }
}
