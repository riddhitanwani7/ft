package com.example.dr.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class AppointmentRequestDto {


    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
    
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    
    @NotNull(message = "Appointment date and time is required")
    private LocalDateTime dateTime;
    
    // Default constructor
    public AppointmentRequestDto() {
    }
    
    // Parameterized constructor
    public AppointmentRequestDto(Long doctorId, Long patientId, LocalDateTime dateTime) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.dateTime = dateTime;
    }
    
    // Getters and setters
    public Long getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
    
    public Long getPatientId() {
        return patientId;
    }
    
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
