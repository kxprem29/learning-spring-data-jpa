package com.kxprem.hospitalManagement;

import com.kxprem.hospitalManagement.entity.Appointment;
import com.kxprem.hospitalManagement.entity.Patient;
import com.kxprem.hospitalManagement.repository.PatientRepository;
import com.kxprem.hospitalManagement.service.AppointmentService;
import com.kxprem.hospitalManagement.service.PatientService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientRepository patientRepository;

//    create 3 appointments for a patient and then delete the patient
//    --- it will also delete the appointments listed with that certain patient
    @Test
    public void testPatient(){
        Appointment a1 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,1,27,12,0,0))
                .reason("Heart")
                .build();
        Appointment a2 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,1,28,12,0,0))
                .reason("Skin")
                .build();
        Appointment a3 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,1,29,12,0,0))
                .reason("Knee")
                .build();

        var na1 = appointmentService.createNewAppointment(a1,1L,2L);
        System.out.println(na1);

        var na2 = appointmentService.createNewAppointment(a2,2L,2L);
        System.out.println(na2);

        var na3 = appointmentService.createNewAppointment(a3,3L,2L);
        System.out.println(na3);


        patientRepository.deleteById(2L);
    }
}
