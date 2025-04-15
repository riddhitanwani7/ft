package com.example.dr.dto;

import java.time.LocalDateTime;

public class AppointmentResponseDto {
    private Long id;
    private LocalDateTime dateTime;
    private DoctorDto doctor;
    private PatientDto patient;
    
    // Default constructor
    public AppointmentResponseDto() {
    }
    
    // Parameterized constructor
    public AppointmentResponseDto(Long id, LocalDateTime dateTime, DoctorDto doctor, PatientDto patient) {
        this.id = id;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    public DoctorDto getDoctor() {
        return doctor;
    }
    
    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }
    
    public PatientDto getPatient() {
        return patient;
    }
    
    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }
}