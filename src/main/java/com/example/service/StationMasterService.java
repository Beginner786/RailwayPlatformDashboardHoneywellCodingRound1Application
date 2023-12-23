package com.example.service;

import com.example.model.TrainDetails;
import com.example.repository.TrainDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class StationMasterService {

    @Autowired
    TrainDetailsRepository trainDetailsRepository;

    public String addTrain(TrainDetails trainDetails)
    {
        TrainDetails fetched= getTrainDetailsByTrainNumber(trainDetails.getTrain_number());
        if(fetched!=null)
            return "Train with given train number: "+trainDetails.getTrain_number()+" already exists!";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        trainDetails.setUpdated_at(timestamp);
        log.info("[addTrain] {}", trainDetails);
        trainDetailsRepository.save(trainDetails);

        return "<script>alert(\"New Train details added successfully! ID: '"+trainDetails.getId()+"' , Train Number: '"+trainDetails.getTrain_number()+"' , Train Name: '"+trainDetails.getTrain_name()+"'\");</script>";
    }

    public TrainDetails getTrainDetailsByTrainNumber(Long id)
    {
        return trainDetailsRepository.findByTrainNumber(id);
    }

    public List<Map<String, Object>> getTrainDetails() {
        return trainDetailsRepository.findAllTrainDetails();
    }

    public String updateTrain(TrainDetails newTrainDetails) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        TrainDetails trainDetail = getTrainDetailsByTrainNumber(newTrainDetails.getTrain_number());
        trainDetail.setTrain_name(newTrainDetails.getTrain_name());
        trainDetail.setTrain_state(newTrainDetails.getTrain_state());
        trainDetail.setTrain_platform(newTrainDetails.getTrain_platform());
        trainDetail.setTrain_time(newTrainDetails.getTrain_time());
        trainDetail.setUpdated_at(timestamp);
        trainDetailsRepository.save(trainDetail);
        return "Train details updated successfully for Train Number: '"+newTrainDetails.getTrain_number()+"'";
    }

    public String deleteTrainByTrainNumber(Long trainNumber) {
        TrainDetails trainDetails=trainDetailsRepository.findByTrainNumber(trainNumber);
        trainDetailsRepository.deleteById(trainDetails.getId());
        return "Train deleted successfully with Train Number: '"+trainNumber+"'";
    }
}
