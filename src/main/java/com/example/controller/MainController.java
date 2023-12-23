package com.example.controller;

import com.example.service.PassengerService;
import com.example.service.StationMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    StationMasterService stationMasterService;

    @Autowired
    PassengerService passengerService;

    @RequestMapping("/")
    public String home()
    {
        return "index";
    }

    @RequestMapping("/trains")
    public String getTrains(Model model)
    {
        model.addAttribute("trains",stationMasterService.getTrainDetails());
        return "trains";
    }

    @RequestMapping("/trainslocalview")
    public String getTrainsLocalView(Model model)
    {
        model.addAttribute("trainslocalview",passengerService.getTrainDetails());
        return "trainslocalview";
    }
}
