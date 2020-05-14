package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findByYear(int year);
    List<Whisky> findByDistilleryRegion(String region);
    List<Whisky> findByAgeAndDistilleryName(Integer age, String distillery);
    List<Whisky> findByNameContaining(String name);
}
