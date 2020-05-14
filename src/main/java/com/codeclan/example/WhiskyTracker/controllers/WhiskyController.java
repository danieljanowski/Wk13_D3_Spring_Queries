package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/whisky/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/whiskies/{id}")
    public ResponseEntity<Whisky> putWhisky(@RequestBody Whisky whisky, @PathVariable Long id){
        if (whisky.getId().longValue() != id){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

    @PostMapping(value = "whiskies")
    public ResponseEntity getWhisky(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }



}
