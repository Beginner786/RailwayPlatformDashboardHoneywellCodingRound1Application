package com.example.service;

import com.example.repository.TrainDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PassengerService {

    @Autowired
    TrainDetailsRepository trainDetailsRepository;

    public List<Map<String, Object>> getTrainDetails() {
        return trainDetailsRepository.findAllTrainDetails();
    }
}
