package com.example.controller;

import com.example.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping("/getPassengerTrainDetails")
    public String getTrainDetails(Model model)
    {
        model.addAttribute(passengerService.getTrainDetails());
        return "index";
    }
}
