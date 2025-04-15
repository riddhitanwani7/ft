package com.example.dr.controller;


import com.example.dr.dto.AppointmentRequestDto;
import com.example.dr.dto.AppointmentResponseDto;
import com.example.dr.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    
    private final AppointmentService appointmentService;
    
    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    
    @PostMapping
    public ResponseEntity<AppointmentResponseDto> createAppointment(
            @Valid @RequestBody AppointmentRequestDto appointmentRequestDto) {
        AppointmentResponseDto createdAppointment = appointmentService.createAppointment(appointmentRequestDto);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }
}