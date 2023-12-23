package com.example.controller;

import com.example.model.TrainDetails;
import com.example.service.StationMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class StationMasterController {

    @Autowired
    StationMasterService stationMasterService;

    @PostMapping("/addTrainDetails")
    public ModelAndView addTrainDetails(@ModelAttribute TrainDetails trainDetails, Model model)
    {
        stationMasterService.addTrain(trainDetails);
        return new ModelAndView("redirect:/trains");
    }

    @GetMapping("/getTrainDetails")
    public String getTrainDetails(Model model)
    {
        model.addAttribute(stationMasterService.getTrainDetails());
        return "index";
    }

    @PostMapping("/updateTrainDetails")
    public ModelAndView updateTrainDetails(@ModelAttribute TrainDetails trainDetails, Model model)
    {
        stationMasterService.updateTrain(trainDetails);
        return new ModelAndView("redirect:/trains");
    }

    @PostMapping("/deleteTrainDetails")
    public ModelAndView deleteTrainDetails(@ModelAttribute TrainDetails trainDetails, Model model)
    {
        stationMasterService.deleteTrainByTrainNumber(trainDetails.getTrain_number());
        return new ModelAndView("redirect:/trains");
    }
}
