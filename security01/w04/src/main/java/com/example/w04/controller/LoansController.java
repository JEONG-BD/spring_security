package com.example.w04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/myLoan")
    public String getLoanDetail(){
        return "Welcome to spring application with out security";
    }
}
