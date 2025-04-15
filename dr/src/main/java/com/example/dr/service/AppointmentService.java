package com.example.dr.service;

import com.example.dr.dto.AppointmentRequestDto;
import com.example.dr.dto.AppointmentResponseDto;
import com.example.dr.dto.DoctorDto;
import com.example.dr.dto.PatientDto;
import com.example.dr.entity.Appointment;
import com.example.dr.entity.Doctor;
import com.example.dr.entity.Patient;
import com.example.dr.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    
    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;
    
    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, 
                             DoctorService doctorService, 
                             PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }
    
    public AppointmentResponseDto createAppointment(AppointmentRequestDto appointmentDto) {
        Doctor doctor = doctorService.getDoctorById(appointmentDto.getDoctorId());
        Patient patient = patientService.getPatientById(appointmentDto.getPatientId());
        
        Appointment appointment = new Appointment();
        appointment.setDateTime(appointmentDto.getDateTime());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        
        Appointment savedAppointment = appointmentRepository.save(appointment);
        
        return mapToAppointmentResponseDto(savedAppointment);
    }
    
    public List<AppointmentResponseDto> getAppointmentsByPatientId(Long patientId) {
        // Verify that the patient exists
        patientService.getPatientById(patientId);
        
        List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
        
        return appointments.stream()
                .map(this::mapToAppointmentResponseDto)
                .collect(Collectors.toList());
    }
    
    private AppointmentResponseDto mapToAppointmentResponseDto(Appointment appointment) {
        AppointmentResponseDto dto = new AppointmentResponseDto();
        dto.setId(appointment.getId());
        dto.setDateTime(appointment.getDateTime());
        
        DoctorDto doctorDto = new DoctorDto(
                appointment.getDoctor().getId(),
                appointment.getDoctor().getName(),
                appointment.getDoctor().getSpecialization()
        );
        dto.setDoctor(doctorDto);
        
        PatientDto patientDto = new PatientDto(
                appointment.getPatient().getId(),
                appointment.getPatient().getName(),
                appointment.getPatient().getContact()
        );
        dto.setPatient(patientDto);
        
        return dto;
    }
}