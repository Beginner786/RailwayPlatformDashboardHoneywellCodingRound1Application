package com.example.repository;

import com.example.model.TrainDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TrainDetailsRepository extends JpaRepository<TrainDetails, Long> {

    @Query(value = "SELECT * FROM train_details u WHERE u.train_number = ?1", nativeQuery = true)
    TrainDetails findByTrainNumber(Long trainNumber);

    @Query(value = "SELECT * FROM train_details", nativeQuery = true)
    List<Map<String, Object>> findAllTrainDetails();
}
