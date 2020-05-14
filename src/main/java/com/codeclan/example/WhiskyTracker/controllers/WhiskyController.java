package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    private WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "region", required = false) String region,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "distname", required = false) String distname
    ){
        if (year != null){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByYear(year),HttpStatus.OK);
        }

        if (region != null){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }

        if (age != null & distname != null){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByAgeAndDistilleryName(age, distname), HttpStatus.OK);
        }

        List<Whisky> foundWhiskies = whiskyRepository.findAll();
        return new ResponseEntity<List<Whisky>>(foundWhiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/glen")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        return new ResponseEntity<List<Whisky>>(whiskyRepository.findByNameContaining("Glen"),HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/begin_the")
    public ResponseEntity<List<Whisky>> getWhiskies(){
        return new ResponseEntity<List<Whisky>>(whiskyRepository.findByNameStartingWith("The"), HttpStatus.OK);
    }


}
