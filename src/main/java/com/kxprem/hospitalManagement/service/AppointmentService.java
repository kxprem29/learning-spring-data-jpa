package com.kxprem.hospitalManagement.service;

import com.kxprem.hospitalManagement.entity.Appointment;
import com.kxprem.hospitalManagement.entity.Doctor;
import com.kxprem.hospitalManagement.entity.Patient;
import com.kxprem.hospitalManagement.repository.AppointmentRepository;
import com.kxprem.hospitalManagement.repository.DoctorRepository;
import com.kxprem.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){

        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        if(appointment.getId()!= null) throw  new IllegalArgumentException("Appointment should not exist without doctor/patient");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointment().add(appointment);  //bi-directional consistency

        return appointmentRepository.save(appointment);
    }


    @Transactional
    public Appointment reassignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); //automatically call

        doctor.getAppointments().add(appointment); //bidirection consistency

        return appointment;
    }
}
