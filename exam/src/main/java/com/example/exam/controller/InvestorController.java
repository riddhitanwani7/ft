package com.example.exam.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exam.entity.Investor;
import com.example.exam.service.InvestorService;

import java.util.List;

@Controller
public class InvestorController {

    private final InvestorService investorService;
    
    @Autowired
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }
    
    @GetMapping("/investors")
    public String getAllInvestors(@RequestParam(required = false) String name, Model model) {
        List<Investor> investors;
        
        if (name != null && !name.isEmpty()) {
            investors = investorService.findByName(name);
            model.addAttribute("searchName", name);
        } else {
            investors = investorService.getAllInvestors();
        }
        
        model.addAttribute("investors", investors);
        return "investors";
    }
    
    @GetMapping("/generate")
    @ResponseBody
    public String generateDummyData() {
        investorService.generateDummyData(50);
        return "50 dummy investors have been generated successfully!";
    }
}