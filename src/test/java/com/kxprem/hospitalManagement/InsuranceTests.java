package com.kxprem.hospitalManagement;

import com.kxprem.hospitalManagement.entity.Appointment;
import com.kxprem.hospitalManagement.entity.Insurance;
import com.kxprem.hospitalManagement.entity.Patient;
import com.kxprem.hospitalManagement.service.AppointmentService;
import com.kxprem.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {


    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance(){
        Insurance insurance =Insurance.builder()
                .policyNumber("HDFC_12345")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,31))
                .build();

        Patient patient =insuranceService.assignInsuranceToPatient(insurance,5L);
        System.out.println(patient);

        //additional test

        Patient updatedPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());

        System.out.println(updatedPatient);

    }

    @Test
    public void testCreateAppointment(){

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,01,24,14,00,00))
                .reason("Cancer")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment,1L, 4L);

        System.out.println(newAppointment);

        var updatedAppointment =appointmentService.reassignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);

        System.out.println(updatedAppointment);
    }
}
