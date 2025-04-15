package com.example.exam.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "investors")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String stockName;
    private BigDecimal investmentAmount;
    private LocalDate investmentDate;
    
    // Default constructor required by JPA
    public Investor() {
    }
    
    // Constructor with all fields except id
    public Investor(String name, String email, String stockName, BigDecimal investmentAmount, LocalDate investmentDate) {
        this.name = name;
        this.email = email;
        this.stockName = stockName;
        this.investmentAmount = investmentAmount;
        this.investmentDate = investmentDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(BigDecimal investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public LocalDate getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(LocalDate investmentDate) {
        this.investmentDate = investmentDate;
    }
    
    @Override
    public String toString() {
        return "Investor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", stockName='" + stockName + '\'' +
                ", investmentAmount=" + investmentAmount +
                ", investmentDate=" + investmentDate +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Investor investor = (Investor) o;
        return Objects.equals(id, investor.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}