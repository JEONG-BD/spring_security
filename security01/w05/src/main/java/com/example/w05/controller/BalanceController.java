package com.example.w05.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/myBalance")
    public String getBalanceDetail(){
        return "Welcome to spring application with out security";
    }
}
