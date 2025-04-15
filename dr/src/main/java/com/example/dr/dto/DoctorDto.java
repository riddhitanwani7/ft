package com.example.dr.dto;




import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

// Doctor DTOs
public class DoctorDto {
    private Long id;
    
    @NotBlank(message = "Doctor name is required")
    private String name;
    
    @NotBlank(message = "Specialization is required")
    private String specialization;
    
    // Default constructor
    public DoctorDto() {
    }
    
    // Parameterized constructor
    public DoctorDto(Long id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
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
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}