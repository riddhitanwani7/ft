package com.example.dr.controller;

import com.example.dr.dto.AppointmentResponseDto;
import com.example.dr.dto.PatientDto;
import com.example.dr.entity.Patient;
import com.example.dr.service.AppointmentService;
import com.example.dr.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    
    @Autowired
    public PatientController(PatientService patientService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }
    
    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientDto patientDto) {
        Patient createdPatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}/appointments")
    public ResponseEntity<List<AppointmentResponseDto>> getPatientAppointments(@PathVariable Long id) {
        List<AppointmentResponseDto> appointments = appointmentService.getAppointmentsByPatientId(id);
        return ResponseEntity.ok(appointments);
    }
}