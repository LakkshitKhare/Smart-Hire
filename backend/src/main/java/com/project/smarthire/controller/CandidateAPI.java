package com.project.smarthire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smarthire.dto.CandidateProfileDTO;
import com.project.smarthire.exception.SmartHireException;
import com.project.smarthire.service.CandidateService;


@RestController
@RequestMapping("api/candidate")
@CrossOrigin(origins = "*")
public class CandidateAPI {

    @Autowired
    CandidateService candidateService;

    @PutMapping("/save")
    public ResponseEntity<String> updateProfile(@RequestBody CandidateProfileDTO dto) throws SmartHireException{
        String message = candidateService.addDetails(dto);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<CandidateProfileDTO> getDetails(@PathVariable String email) throws SmartHireException{
        CandidateProfileDTO candidate = candidateService.getDetails(email); 
        return new ResponseEntity<>(candidate,HttpStatus.OK);
    }

}
