package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    private DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(
            @RequestParam(name = "region", required = false) String region
    ){
        if (region != null){
            return new ResponseEntity<List<Distillery>> (distilleryRepository.findByRegion(region), HttpStatus.OK);
        }

        List<Distillery> foundDistilleries = distilleryRepository.findAll();
        return new ResponseEntity<List<Distillery>>(foundDistilleries, HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/age12")
        public ResponseEntity<List<Distillery>> getAllDistilleries() {
        return new ResponseEntity<>(distilleryRepository.findByWhiskiesAgeEquals(12), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/whisky_the")
        public ResponseEntity<List<Distillery>> getAllDistlleries(){
        return new ResponseEntity<>(distilleryRepository.findByWhiskiesNameStartingWith("The"), HttpStatus.OK);
    }

}
