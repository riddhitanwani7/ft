package com.example.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exam.entity.Investor;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    
    // Method to search investors by name (case-insensitive)
    List<Investor> findByNameContainingIgnoreCase(String name);
}