package com.example.dr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PatientDto {
    private Long id;
    
    @NotBlank(message = "Patient name is required")
    private String name;
    
    @NotBlank(message = "Contact information is required")
    private String contact;
    
    // Default constructor
    public PatientDto() {
    }
    
    // Parameterized constructor
    public PatientDto(Long id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
}