package com.kxprem.hospitalManagement;

import com.kxprem.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.kxprem.hospitalManagement.entity.Patient;
import com.kxprem.hospitalManagement.entity.type.BloodGroupType;
import com.kxprem.hospitalManagement.repository.PatientRepository;
import com.kxprem.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList=patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){
//        Patient patient =patientService.getPatientbyId(1L);

//        Patient patient= patientRepository.findByName("Diya Patel");

//        List<Patient> patientList=patientRepository.findByBirthDateOrEmail(LocalDate.of(1988,3,15),"diya.patel@example.com");


//        List<Patient> patientList=patientRepository.findByBornAfterDate(LocalDate.of(1993,1,1));

//                findByBloodGroup(BloodGroupType.A_POSITIVE);

//                .findByNameContainingOrderByIdDesc("Di");

        Page<Patient> patientList =patientRepository.findAllPatients(PageRequest.of(0,2, Sort.by("name")));

        for(Patient patient: patientList){
            System.out.println(patient);
        }

//        using JPQL but will be bettered by Projection
//        List<Object[]> bloodGroupList=patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0]+" "+objects[1]);
//        }

//        projection one:
//        List<BloodGroupCountResponseEntity> bloodGroupList=patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponseEntity: bloodGroupList){
//            System.out.println(bloodGroupCountResponseEntity);
//        }

//        int numberOfPatientUpdated = patientRepository.updateNameWithId("Aarav Singh", 2L);

    }

}
