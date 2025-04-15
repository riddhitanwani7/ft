package com.example.exam.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exam.entity.*;
import com.example.exam.repository.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;
    private final Random random = new Random();
    
    // Sample data for random generation
    private final List<String> firstNames = Arrays.asList(
            "John", "Emma", "Michael", "Olivia", "William", "Sophia", "James", "Isabella", 
            "Benjamin", "Charlotte", "Lucas", "Amelia", "Henry", "Ava", "Alexander", "Mia",
            "Daniel", "Harper", "Matthew", "Evelyn");
            
    private final List<String> lastNames = Arrays.asList(
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
            "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
            "Thomas", "Taylor", "Moore", "Jackson", "Martin");
    
    private final List<String> stockNames = Arrays.asList(
            "AAPL", "GOOG", "MSFT", "AMZN", "TSLA", "FB", "NFLX", "NVDA", 
            "JPM", "V", "WMT", "PG", "JNJ", "DIS", "BAC", "INTC", "VZ", "CSCO", "PFE", "KO");

    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }
    
    public List<Investor> findByName(String name) {
        if (name == null || name.isEmpty()) {
            return getAllInvestors();
        }
        return investorRepository.findByNameContainingIgnoreCase(name);
    }

    public void generateDummyData(int count) {
        List<Investor> investors = IntStream.range(0, count)
                .mapToObj(i -> createRandomInvestor())
                .collect(Collectors.toList());
        
        investorRepository.saveAll(investors);
    }
    
    private Investor createRandomInvestor() {
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));
        String name = firstName + " " + lastName;
        
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
        String stockName = stockNames.get(random.nextInt(stockNames.size()));
        
        // Generate random investment amount between 1,000 and 100,000
        BigDecimal investmentAmount = BigDecimal.valueOf(1000 + random.nextInt(99000));
        
        // Generate random date from last 5 years
        LocalDate now = LocalDate.now();
        long minDay = now.minusYears(5).toEpochDay();
        long maxDay = now.toEpochDay();
        long randomDay = minDay + random.nextInt((int) (maxDay - minDay));
        LocalDate investmentDate = LocalDate.ofEpochDay(randomDay);
        
        return new Investor(name, email, stockName, investmentAmount, investmentDate);
    }
}